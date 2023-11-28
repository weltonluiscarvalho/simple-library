package com.veltopia.library.kafka;

import com.veltopia.avro.UserValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);

    private final KafkaTemplate<String, UserValue> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, UserValue> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserValue message) {
        logger.info("Sending message: {}", message);
        kafkaTemplate.send("${producer.object.topic.name}", message);
        logger.info("Message send {}", message);
    }

}