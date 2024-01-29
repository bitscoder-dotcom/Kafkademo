package com.bitcoderdotcom.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message) {
        kafkaTemplate.send("bitscoder", message);
    }
}
