package com.example.projectB.service;

import com.example.projectB.models.Customer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.lang.String.format;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "userMessage4";

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public void sendMessage(String message) {
        LOGGER.info(format("***************** Produce Message -> %s", message));
        Customer customer = Customer.newBuilder()
                .setName("Wikered")
                .setMessage(message)
                .build();

        Customer customer2 = Customer.newBuilder()
                .setName("Customer2")
                .setMessage(message)
                .build();
        //ProducerRecord record = new ProducerRecord(TOPIC, null, customer);
        kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), customer);
        kafkaTemplate.send(TOPIC, null, customer2);
    }

}
