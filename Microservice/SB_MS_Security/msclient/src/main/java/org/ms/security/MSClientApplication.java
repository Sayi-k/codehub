package org.ms.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MSClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MSClientApplication.class, args);
    }
}
