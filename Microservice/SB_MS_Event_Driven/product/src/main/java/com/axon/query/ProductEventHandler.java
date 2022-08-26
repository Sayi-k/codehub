package com.axon.query;

import com.axon.core.data.ProductEntity;
import com.axon.core.data.ProductRepository;
import com.axon.core.event.ProductCreatedEvent;
import com.core.event.ProductReservationCancelledEvent;
import com.core.event.ProductReservedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product_group")
@Slf4j
public class ProductEventHandler {

    @Autowired
    ProductRepository repository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(event, entity);
        repository.save(entity);
    }

    @EventHandler
    public void on(ProductReservedEvent event){
        ProductEntity entity = repository.findByProductId(event.getProductId());
        entity.setQuantity(entity.getQuantity() - event.getQuantity());
        repository.save(entity);
    }

    @EventHandler
    public void on(ProductReservationCancelledEvent event){
        ProductEntity entity = repository.findByProductId(event.getProductId());
        entity.setQuantity(entity.getQuantity() + event.getQuantity());
        repository.save(entity);
    }

    @ResetHandler
    public void reset(){
        repository.deleteAll();
    }
}
