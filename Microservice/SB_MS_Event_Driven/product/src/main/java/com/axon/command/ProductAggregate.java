package com.axon.command;

import com.axon.core.event.ProductCreatedEvent;
import com.core.command.CancelProductReservationCommand;
import com.core.command.ReserveProductCommand;
import com.core.event.ProductReservationCancelledEvent;
import com.core.event.ProductReservedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Slf4j
@Aggregate(snapshotTriggerDefinition = "product_snapshot")
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private int quantity;

    public ProductAggregate(){}

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        if (command.getPrice() <= 0) throw new IllegalArgumentException("Product should have valid price");
        if (command.getName() == null || command.getName().isEmpty())
            throw new IllegalArgumentException("Product should have valid name");
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.productId =productCreatedEvent.getProductId();
        this.name=productCreatedEvent.getName();
        this.price=productCreatedEvent.getPrice();
        this.quantity=productCreatedEvent.getQuantity();
    }

    @CommandHandler
    public void handle(ReserveProductCommand command){
        if (this.quantity < command.getQuantity())
            throw new IllegalArgumentException("Insufficient number of items in stock");
        ProductReservedEvent event = new ProductReservedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductReservedEvent event){

        this.quantity -= event.getQuantity();
    }

    @CommandHandler
    public void handle(CancelProductReservationCommand command){
        ProductReservationCancelledEvent event = new ProductReservationCancelledEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductReservationCancelledEvent event){

        this.quantity += event.getQuantity();
    }
}
