package com.axon.query.model;

import com.axon.command.OrderStatus;
import lombok.Data;

@Data
public class OrderSummary {

    private final String orderId;
    private final OrderStatus orderStatus;
    private final String reason;
}
