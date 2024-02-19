package com.bitcoderdotcom.kafkademo.controller;

import com.bitcoderdotcom.kafkademo.payload.Student;
import com.bitcoderdotcom.kafkademo.producer.KafkaJsonProducer;
import com.bitcoderdotcom.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {

        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {

        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as Json");
    }
}
