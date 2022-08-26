package com.axon.command.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class ProductReqModel {

    @NotEmpty(message = "Product name cant be empty")
    private String name;
    @Min(value = 1, message = "Product price should be more than 1")
    private double price;
    private int quantity;
}
