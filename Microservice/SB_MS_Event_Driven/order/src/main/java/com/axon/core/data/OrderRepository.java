package com.axon.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    public OrderEntity findByOrderId(String orderId);
}
