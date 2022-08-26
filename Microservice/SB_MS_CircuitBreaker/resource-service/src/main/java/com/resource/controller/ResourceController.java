package com.resource.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ResourceController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @SneakyThrows
    public String getResourceMessage(){
        log.info("{} - {}", "ResourceController", "getResourceMessage");
        Thread.sleep(10000);
        return "Resource message says HI...";
    }
}
