package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    KafkaTemplate<String, String> template;

    @GetMapping("/{msg}")
    @ResponseStatus(HttpStatus.OK)
    public String send(@PathVariable String msg){
        template.send("kafka_topic",msg);
        return "Sent successfully : "+ msg;
    }
}
