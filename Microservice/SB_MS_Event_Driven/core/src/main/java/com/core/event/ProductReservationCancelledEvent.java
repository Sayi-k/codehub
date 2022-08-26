package com.core.event;

import lombok.Data;

@Data
public class ProductReservationCancelledEvent {
    private String productId;
    private String orderId;
    private int quantity;
    private String userId;
    private String reason;
}
