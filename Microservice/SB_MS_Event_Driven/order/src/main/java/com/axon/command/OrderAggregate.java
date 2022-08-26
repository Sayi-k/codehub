package com.axon.command;

import com.axon.core.event.OrderApprovedEvent;
import com.axon.core.event.OrderCreatedEvent;
import com.axon.core.event.OrderRejectedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Slf4j
@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;

    public OrderAggregate(){}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        OrderCreatedEvent event =new OrderCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        this.orderId=event.getOrderId();
        this.userId=event.getUserId();
        this.productId=event.getProductId();
        this.quantity=event.getQuantity();
        this.addressId=event.getAddressId();
        this.orderStatus=event.getOrderStatus();
    }

    @CommandHandler
    public void handle(ApproveOrderCommand command){
        OrderApprovedEvent event = new OrderApprovedEvent(command.getOrderId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(OrderApprovedEvent event){
        this.orderStatus = event.getOrderStatus();
    }

    @CommandHandler
    public void handle(RejectOrderCommand command){
        OrderRejectedEvent event = new OrderRejectedEvent(command.getOrderId(), command.getReason());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(OrderRejectedEvent event){
        this.orderStatus = event.getOrderStatus();
    }
}
