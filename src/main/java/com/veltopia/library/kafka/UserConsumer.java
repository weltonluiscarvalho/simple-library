package com.veltopia.library.kafka;

import com.veltopia.avro.UserId;
import com.veltopia.library.services.UserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
	
    private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

	@Autowired
	private UserService userService;

	  @KafkaListener(topics = "${consumer.object.topic.name}", groupId = "${consumer.object.consumer.group}")
	  public void consumer(ConsumerRecord<String, UserId> record) {
		  userService.searchUserById(record.value().getId());
		  logger.info("Receiving data: {}", record.value().toString());
	  }
}