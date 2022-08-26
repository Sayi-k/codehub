package com.axon.command;

import com.core.command.ProcessPaymentCommand;
import com.core.event.PaymentProcessedEvent;
import com.core.model.PaymentDetails;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentAggregate {

    @AggregateIdentifier
    private String paymentId;
    private String orderId;

    @CommandHandler
    public PaymentAggregate(ProcessPaymentCommand command){
        if (command.getPaymentId() == null)
            throw new IllegalArgumentException("Payment ID is must in Order ID: "+ command.getOrderId());
        PaymentProcessedEvent event = new PaymentProcessedEvent(command.getOrderId(), command.getPaymentId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentProcessedEvent event){
        this.paymentId = event.getPaymentId();
        this.orderId = event.getOrderId();
    }
}
