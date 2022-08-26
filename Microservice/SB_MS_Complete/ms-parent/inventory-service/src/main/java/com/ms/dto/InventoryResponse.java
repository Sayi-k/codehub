package com.ms.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private Integer quantity;
    private boolean isStockPresent;
}
