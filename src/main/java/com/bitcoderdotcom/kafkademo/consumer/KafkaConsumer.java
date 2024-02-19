package com.bitcoderdotcom.kafkademo.consumer;

import com.bitcoderdotcom.kafkademo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "bitscoder", groupId = "myGroup")
    public void consumeMsg(String message) {
      log.info(String.format("Consuming the message from bitscoder topic:: %s", message));
    }

    @KafkaListener(topics = "Bitscoder", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
      log.info(String.format("Consuming the message from bitscoder topic:: %s", student.toString()));
    }
}
