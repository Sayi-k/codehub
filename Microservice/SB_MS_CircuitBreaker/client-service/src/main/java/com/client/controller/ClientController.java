package com.client.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    public WebClient.Builder webClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //@CircuitBreaker(name = "somename", fallbackMethod = "fallbackMethod")
    //@Retry(name = "somename", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "somename", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "somename", fallbackMethod = "fallbackMethod")
    public CompletableFuture<String> getClientMessage(){

        return CompletableFuture.supplyAsync(() -> {
            log.info("{} - {}", "ClientController", "getClientMessage");
            String message = getString();
            return "Client called Resource: => "+message;
        }) ;
    }

    private String getString() {
        return webClient.build()
                .get()
                .uri("http://localhost:8091")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public CompletableFuture<String> fallbackMethod(Exception exception){
        return CompletableFuture.supplyAsync(() -> "Exception occurred => "+exception.getMessage()) ;
    }
}
