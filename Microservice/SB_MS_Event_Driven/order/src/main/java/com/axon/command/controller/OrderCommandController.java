package com.axon.command.controller;

import com.axon.command.CreateOrderCommand;
import com.axon.command.OrderStatus;
import com.axon.command.model.OrderReqModel;
import com.axon.query.FindOrderQuery;
import com.axon.query.model.OrderSummary;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderCommandController {

    @Autowired
    CommandGateway commandGateway;

    @Autowired
    QueryGateway queryGateway;

    @PostMapping
    public OrderSummary saveOrder(@Valid @RequestBody OrderReqModel model){
        final String orderId = UUID.randomUUID().toString();

        CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
                .orderId(orderId)
                .productId(model.getProductId())
                .addressId(model.getAddressId())
                .quantity(model.getQuantity())
                .orderStatus(OrderStatus.CREATED)
                .userId(UUID.randomUUID().toString())
                .build();

        SubscriptionQueryResult<OrderSummary, OrderSummary> queryResult =
                queryGateway.subscriptionQuery(new FindOrderQuery(orderId),
                ResponseTypes.instanceOf(OrderSummary.class),
                ResponseTypes.instanceOf(OrderSummary.class));

        try {
            commandGateway.sendAndWait(createOrderCommand);
            return queryResult.updates().blockFirst();
        }finally {
            queryResult.close();
        }

    }
}
