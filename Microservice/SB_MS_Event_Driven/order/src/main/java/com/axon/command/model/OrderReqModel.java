package com.axon.command.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OrderReqModel {

    @NotBlank(message = "Order productId is a required field")
    String productId;

    @Min(value = 1, message = "Quantity cannot be lower than 1")
    @Max(value = 5, message = "Quantity cannot be larger than 5")
    int quantity;

    @NotBlank(message = "Order addressId is a required field")
    String addressId;
}
