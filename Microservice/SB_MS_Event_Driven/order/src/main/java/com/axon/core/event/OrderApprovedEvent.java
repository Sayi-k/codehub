package com.axon.core.event;

import com.axon.command.OrderStatus;
import lombok.Data;

@Data
public class OrderApprovedEvent {

    private final String orderId;
    private final OrderStatus orderStatus = OrderStatus.APPROVED;
}
