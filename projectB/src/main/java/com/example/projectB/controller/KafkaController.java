package com.example.projectB.controller;

import com.example.projectB.service.ProducerService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {


    private final ProducerService producerService;

    public KafkaController(final ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public void sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
    }

    @Bean
    public KafkaAdmin.NewTopics adviceTopic() {
        return new KafkaAdmin.NewTopics(
                new NewTopic("userMessage", 3, (short) 1),
                new NewTopic("user", 3, (short) 1));
    }
}
