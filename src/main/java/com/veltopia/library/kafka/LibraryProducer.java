package com.veltopia.library.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import com.veltopia.library.avro.userBook;

public class LibraryProducer {
	
	private final KafkaTemplate<String, userBook> kafkaTemplate;

    public LibraryProducer(KafkaTemplate<String, userBook> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(userBook message) {
        kafkaTemplate.send("${transfer.object.topic.name}", message);
    }

}
