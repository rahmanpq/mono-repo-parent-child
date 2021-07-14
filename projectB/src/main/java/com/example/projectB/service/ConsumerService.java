package com.example.projectB.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class ConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);


    public void consumeMessage(String message) {
        LOGGER.info(format("*****-> Consume Message ----> %s", message));
    }
}
