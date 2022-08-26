package com.ms.service;

import com.ms.dto.InventoryResponse;
import com.ms.entity.Inventory;
import com.ms.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class  InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){

        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> convertToInventoryResp(inventory))
                .collect(Collectors.toList());
    }

    private InventoryResponse convertToInventoryResp(Inventory inventory) {
        return InventoryResponse.builder()
                .id(inventory.getId())
                .skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity())
                .isStockPresent(inventory.getQuantity() > 0)
                .build();
    }

}
