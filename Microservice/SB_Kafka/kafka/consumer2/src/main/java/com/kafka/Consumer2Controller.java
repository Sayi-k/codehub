package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Consumer2Controller {
    public static void main(String[] args) {
        SpringApplication.run(Consumer2Controller.class, args);
    }

    @KafkaListener(topics = "kafka_topic", groupId = "new_grp")
    public void consumer(String message){
        System.out.println(message);
    }
}
