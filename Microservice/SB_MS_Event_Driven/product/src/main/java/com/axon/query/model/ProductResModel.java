package com.axon.query.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResModel {
    private String productId;
    private String name;
    private double price;
    private int quantity;
}
