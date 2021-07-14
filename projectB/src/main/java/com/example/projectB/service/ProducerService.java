package com.example.projectB.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "userMessage";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message) {
        LOGGER.info(format("***************** Produce Message -> %s", message));
        kafkaTemplate.send(TOPIC, message.getBytes(StandardCharsets.UTF_8));
    }

}
