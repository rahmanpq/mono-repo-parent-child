package com.example.projectB.service;

import com.example.projectB.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "userMessage";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message) {
        var customer = Customer.newBuilder().setMessage("message 1").build();
        LOGGER.info(format("***************** Produce Message -> %s", message));
        kafkaTemplate.send(TOPIC, message);
    }

}
