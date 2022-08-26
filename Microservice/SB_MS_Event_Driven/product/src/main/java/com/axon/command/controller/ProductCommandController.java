package com.axon.command.controller;

import com.axon.command.CreateProductCommand;
import com.axon.command.model.ProductReqModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductCommandController {

    @Autowired
    CommandGateway gateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody ProductReqModel model) {
        //validation
        CreateProductCommand command = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(model.getName())
                .price(model.getPrice())
                .quantity(model.getQuantity())
                .build();
        return gateway.sendAndWait(command);
    }

}
