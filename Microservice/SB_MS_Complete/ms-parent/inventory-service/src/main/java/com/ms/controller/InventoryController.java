package com.ms.controller;

import com.ms.dto.InventoryResponse;
import com.ms.service.InventoryService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService  inventoryService;

    //http://localhost:8092/api/inventory?skuCode=samsung_13,samsung_16
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @SneakyThrows //Do not use in PROD. Handle exception in try catch for Thread.sleep
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        log.info("Inside Inventory");
        Thread.sleep(4000);
        return inventoryService.isInStock(skuCode);
    }
}
