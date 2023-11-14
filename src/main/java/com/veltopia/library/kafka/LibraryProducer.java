package com.veltopia.library.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LibraryProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    public LibraryProducer(KafkaTemplate<String, String> kafkaTemplate, @Value("${transfer.object.topic.name}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }
}