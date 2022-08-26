package com.axon.command;

import com.axon.core.data.ProductLookupEntity;
import com.axon.core.data.ProductLookupRepository;
import com.axon.core.event.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product_group")
public class ProductLookupEventHandler {

    @Autowired
    ProductLookupRepository repository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductLookupEntity entity = new ProductLookupEntity(event.getProductId(), event.getName());
        repository.save(entity);
    }

    @ResetHandler
    public void reset(){
        repository.deleteAll();
    }
}
