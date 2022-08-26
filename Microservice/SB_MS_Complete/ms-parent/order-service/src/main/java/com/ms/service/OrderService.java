package com.ms.service;

import com.ms.dto.OrderItemReq;
import com.ms.dto.OrderItemRes;
import com.ms.dto.OrderRequest;
import com.ms.dto.OrderResponse;
import com.ms.dto.inventory.InventoryResponse;
import com.ms.entity.Order;
import com.ms.entity.OrderItem;
import com.ms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private Tracer tracer;

    public OrderResponse createOrder(OrderRequest orderRequest){
        Order order = convertToOrder(orderRequest);

        Span inventoryServiceLookup = tracer.nextSpan().name("InventoryServiceLookup");

        try (Tracer.SpanInScope spanInScope = tracer.withSpan(inventoryServiceLookup.start())) {
            boolean isAllStokeAvailable = checkInventory(order);

            if(!isAllStokeAvailable){
                throw new IllegalArgumentException("Stock is unavailable...!");
            }
            Order orderSaved = orderRepository.save(order);
            return convertToOrderResponse(orderSaved);
        }
        finally {
            inventoryServiceLookup.end();
        }
    }

    private boolean checkInventory(Order order) {
        List<String> skuCodeList = order.getOrderItemList().stream()
                .map(OrderItem::getSkuCode).collect(Collectors.toList());

        List<InventoryResponse> invRespList = webClientBuilder.build()
                .get()
                .uri("http://inventory-service/api/inventory", uriBuilder ->
                        uriBuilder.queryParam("skuCode",skuCodeList).build())
                .retrieve()
                .bodyToFlux(InventoryResponse.class)
                .collectList()
                .block();

        return invRespList.stream().allMatch(InventoryResponse::isStockPresent);
    }

    private OrderResponse convertToOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderItemList(
                        order.getOrderItemList().stream()
                                .map(item -> convertToOrderItemRes(item))
                                .collect(Collectors.toList())
                )
                .build();
    }

    private OrderItemRes convertToOrderItemRes(OrderItem item) {
        return OrderItemRes.builder()
                .id(item.getId())
                .skuCode(item.getSkuCode())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }

    private Order convertToOrder(OrderRequest orderRequest) {
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderItemList(
                        orderRequest.getOrderItemList().stream()
                                .map(this::convertToOrderItem)
                                .collect(Collectors.toList())
                )
                .build();
    }

    private OrderItem convertToOrderItem(OrderItemReq req) {
        return OrderItem.builder()
                .skuCode(req.getSkuCode())
                .price(req.getPrice())
                .quantity(req.getQuantity())
                .build();
    }
}
