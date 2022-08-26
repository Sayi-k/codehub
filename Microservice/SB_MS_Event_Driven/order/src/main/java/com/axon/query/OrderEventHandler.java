package com.axon.query;

import com.axon.core.data.OrderEntity;
import com.axon.core.data.OrderRepository;
import com.axon.core.event.OrderApprovedEvent;
import com.axon.core.event.OrderCreatedEvent;
import com.axon.core.event.OrderRejectedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("order-group")
public class OrderEventHandler {

    @Autowired
    OrderRepository repository;

    @EventHandler
    public void on(OrderCreatedEvent event){
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(event, entity);
        repository.save(entity);
    }

    @EventHandler
    public void on(OrderApprovedEvent event){
        OrderEntity orderEntity = repository.findByOrderId(event.getOrderId());
        if (orderEntity == null){
            //Do something
        }
        orderEntity.setOrderStatus(event.getOrderStatus());
        repository.save(orderEntity);
    }

    @EventHandler
    public void on(OrderRejectedEvent event){
        OrderEntity orderEntity = repository.findByOrderId(event.getOrderId());
        if (orderEntity == null){
            //Do something
        }
        orderEntity.setOrderStatus(event.getOrderStatus());
        repository.save(orderEntity);
    }
}
