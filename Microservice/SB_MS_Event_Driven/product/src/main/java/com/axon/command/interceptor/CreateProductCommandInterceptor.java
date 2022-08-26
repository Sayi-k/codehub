package com.axon.command.interceptor;

import com.axon.command.CreateProductCommand;
import com.axon.core.data.ProductLookupEntity;
import com.axon.core.data.ProductLookupRepository;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Component
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    @Autowired
    ProductLookupRepository repository;

    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<?
            extends CommandMessage<?>> list) {

        return (index, command) -> {
            if (CreateProductCommand.class.equals(command.getPayloadType())){
                CreateProductCommand createProductCommand = (CreateProductCommand)command.getPayload();
                ProductLookupEntity entity =repository.findByProductIdOrName(createProductCommand.getProductId(),
                        createProductCommand.getName());
                if (entity != null){
                    throw new IllegalStateException(
                            String.format("The product ID: %s or name: %s is already present"
                                    , createProductCommand.getProductId(), createProductCommand.getName()));
                }
            }
            return command;
        };
    }
}
