package com.axon.core.event;

import com.axon.command.OrderStatus;
import lombok.Data;

@Data
public class OrderRejectedEvent {

    private final String orderId;
    private final String reason;
    private final OrderStatus orderStatus = OrderStatus.REJECTED;
}
