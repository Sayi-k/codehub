package com.axon.core.event;

import lombok.Data;

@Data
public class ProductCreatedEvent {

    private String productId;
    private String name;
    private double price;
    private int quantity;
}
