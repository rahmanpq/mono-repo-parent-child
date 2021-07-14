package com.example.projectB;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.String.format;

@Configuration("UserKafkaConsumerProcessor")
public class UserKafkaConsumerProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserKafkaConsumerProcessor.class);

    @Bean
    public Consumer<KStream<String, String>> userService() {
        LOGGER.info(format("*****-> Consume Stream Message ---->"));

        return kstream -> kstream.foreach(
                (key, value) -> LOGGER.info("Message Recevied in Consumer ----> " + value));

    }
}
