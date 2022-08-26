package com.axon.saga;

import com.axon.command.ApproveOrderCommand;
import com.axon.command.RejectOrderCommand;
import com.axon.core.event.OrderApprovedEvent;
import com.axon.core.event.OrderCreatedEvent;
import com.axon.core.event.OrderRejectedEvent;
import com.axon.query.FindOrderQuery;
import com.axon.query.model.OrderSummary;
import com.core.command.CancelProductReservationCommand;
import com.core.command.ProcessPaymentCommand;
import com.core.command.ReserveProductCommand;
import com.core.event.PaymentProcessedEvent;
import com.core.event.ProductReservationCancelledEvent;
import com.core.event.ProductReservedEvent;
import com.core.model.User;
import com.core.query.FetchUserPaymentDetailsQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.deadline.DeadlineManager;
import org.axonframework.deadline.annotation.DeadlineHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Saga
@Slf4j
public class OrderSaga {

    public static final String PROCESS_PAYMENT_DEADLINE = "process_payment_deadline";
    @Autowired
    private transient CommandGateway commandGateway;
    @Autowired
    private transient QueryGateway queryGateway;
    @Autowired
    private transient DeadlineManager deadlineManager;
    @Autowired
    private transient QueryUpdateEmitter queryUpdateEmitter;

    private String deadlineScheduleId;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent event) {

        ReserveProductCommand command = ReserveProductCommand.builder()
                .orderId(event.getOrderId())
                .productId(event.getProductId())
                .userId(event.getUserId())
                .quantity(event.getQuantity())
                .build();
        commandGateway.send(command, (commandMessage, commandResultMessage) -> {
            //Start compensation transaction
            RejectOrderCommand rejectOrderCommand = new RejectOrderCommand(event.getOrderId()
                    , commandResultMessage.exceptionResult().getMessage());
            commandGateway.send(rejectOrderCommand);
        });
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(ProductReservedEvent event) {
        User user = null;
        FetchUserPaymentDetailsQuery query = new FetchUserPaymentDetailsQuery(event.getUserId());
        try {
            user = queryGateway.query(query, ResponseTypes.instanceOf(User.class)).join();
        } catch (Exception exception) {
            //Start compensation transaction
            cancelProductReservation(event, exception.getMessage());
            return;
        }
        if (user == null) {
            //Start compensation transaction
            cancelProductReservation(event, "User not present for the User ID: " + event.getUserId());
            return;
        }
        log.info("Successfully fetched Used payment details for user: {}", user.getFirstName());

        deadlineScheduleId = deadlineManager.schedule(Duration.of(150, ChronoUnit.SECONDS)
                , PROCESS_PAYMENT_DEADLINE, event);

        ProcessPaymentCommand processPaymentCommand = ProcessPaymentCommand.builder()
                .paymentId(UUID.randomUUID().toString())
                .orderId(event.getOrderId())
                .paymentDetails(user.getPaymentDetails())
                .build();
        String processPaymentResult = null;
        try {
            processPaymentResult = commandGateway.sendAndWait(processPaymentCommand);
        } catch (Exception exception) {
            //Start compensation transaction
            cancelProductReservation(event, exception.getMessage());
            return;
        }
        if (processPaymentResult == null) {
            //Start compensation transaction
            cancelProductReservation(event, "Payment details not present for the User: " + event.getUserId());
            return;
        }
    }

    private void cancelProductReservation(ProductReservedEvent event, String message) {
        CancelProductReservationCommand cancelProductReservationCommand = CancelProductReservationCommand.builder()
                .productId(event.getProductId())
                .orderId(event.getOrderId())
                .userId(event.getUserId())
                .quantity(event.getQuantity())
                .reason(message)
                .build();
        commandGateway.send(cancelProductReservationCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(PaymentProcessedEvent event) {

        deadlineManager.cancelSchedule(PROCESS_PAYMENT_DEADLINE, deadlineScheduleId);
        ApproveOrderCommand command = new ApproveOrderCommand(event.getOrderId());
        commandGateway.send(command);
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderApprovedEvent event) {

        log.info("Saga ended: Got OrderApprovedEvent successfully");
        queryUpdateEmitter.emit(FindOrderQuery.class, query -> true,
                new OrderSummary(event.getOrderId(), event.getOrderStatus(), ""));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(ProductReservationCancelledEvent event) {
        RejectOrderCommand command = new RejectOrderCommand(event.getOrderId(), event.getReason());
        commandGateway.send(command);
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderRejectedEvent event) {
        log.info("Order: {} has been rejected for reason: {} ", event.getOrderId(), event.getReason());
        queryUpdateEmitter.emit(FindOrderQuery.class, query -> true,
                new OrderSummary(event.getOrderId(), event.getOrderStatus(), event.getReason()));
    }

    @DeadlineHandler(deadlineName = PROCESS_PAYMENT_DEADLINE)
    public void handleDeadline(ProductReservedEvent event) {
        cancelProductReservation(event, "Payment timeout");
    }
}
