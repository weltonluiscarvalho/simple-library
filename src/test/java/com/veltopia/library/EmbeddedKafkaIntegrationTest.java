package com.veltopia.library;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import com.veltopia.library.kafka.LibraryProducer;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092"})
public class EmbeddedKafkaIntegrationTest {

	@Autowired
	private LibraryProducer producer;
	
	@Test
    public void testarApp() throws Exception {
        String data = "Sending with our own simple KafkaProducer";
        assertTrue(true);
        producer.sendMessage(data);
    }
}
