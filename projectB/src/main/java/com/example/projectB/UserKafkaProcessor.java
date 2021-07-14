package com.example.projectB;

import com.example.projectB.service.ConsumerService;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import static java.lang.String.format;

@Configuration("UserKafkaProcessor")
public class UserKafkaProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserKafkaProcessor.class);

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> userProcessor() {
        LOGGER.info(format("*****-> Consume Stream Message ---->"));

        return kstream -> kstream.map(
                (key, value) -> KeyValue.pair(value.toLowerCase(), value + "Hurray"));

    }
}
