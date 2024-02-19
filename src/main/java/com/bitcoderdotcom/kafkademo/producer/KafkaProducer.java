package com.bitcoderdotcom.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message) {
        log.info(String.format("Sending message to bitscoder topic:: %s", message));
        kafkaTemplate.send("Bitscoder", message);
    }
}
