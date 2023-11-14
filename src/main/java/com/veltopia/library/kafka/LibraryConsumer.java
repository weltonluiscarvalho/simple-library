package com.veltopia.library.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LibraryConsumer {
	
    private static final Logger logger = LoggerFactory.getLogger(LibraryConsumer.class);

	  @KafkaListener(topics = "${transfer.object.topic.name}", groupId =
	  "${transfer.object.groupid}") public void consumer(@Payload String message) {
	  logger.info(message); }
}