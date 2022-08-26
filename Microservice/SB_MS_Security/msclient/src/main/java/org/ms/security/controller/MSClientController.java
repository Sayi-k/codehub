package org.ms.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

@RestController
@RequestMapping("msclient")
public class MSClientController {

    private final WebClient webClient = WebClient.builder().build();

    @GetMapping
    public String getMessageFromResource(){

        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String resourceMessage =webClient
                .get()
                .uri("http://localhost:8781/msresource")
                .headers(head -> head.setBearerAuth(jwt.getTokenValue()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "Client got the message from resource as -> " +resourceMessage;
    }
}
