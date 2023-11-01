package com.veltopia.library.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class LibraryConsumer {
	
	@KafkaListener(topics = "${transfer.object.topic.name}", groupId = "${transfer.object.groupid}")
	public void consumer(@Payload String message) {	
		System.out.println(message);
	}

}
