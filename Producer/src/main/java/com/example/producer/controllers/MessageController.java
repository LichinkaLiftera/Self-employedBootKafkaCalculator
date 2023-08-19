package com.example.producer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MessageController {
    private final KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendMessage(Integer messageId, String message) {
        kafkaTemplate.send("message", messageId, message);
    }
}
