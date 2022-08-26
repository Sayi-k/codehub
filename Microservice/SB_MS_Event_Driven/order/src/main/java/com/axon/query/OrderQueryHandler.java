package com.axon.query;

import com.axon.core.data.OrderEntity;
import com.axon.core.data.OrderRepository;
import com.axon.query.model.OrderSummary;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class OrderQueryHandler {

    OrderRepository repository;

    public OrderQueryHandler(OrderRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public OrderSummary handle(FindOrderQuery query){
        OrderEntity entity = repository.findByOrderId(query.getOrderId());
        return new OrderSummary(entity.getOrderId(), entity.getOrderStatus(), "");
    }
}
