package com.axon.query;

import com.axon.core.data.PaymentEntity;
import com.axon.core.data.PaymentRepository;
import com.core.event.PaymentProcessedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("payment-group")
public class PaymentEventsHandler {

    @Autowired
    PaymentRepository paymentRepository;

    @EventHandler
    public void on(PaymentProcessedEvent event){
        PaymentEntity entity = new PaymentEntity();
        BeanUtils.copyProperties(event, entity);
        paymentRepository.save(entity);
    }
}
