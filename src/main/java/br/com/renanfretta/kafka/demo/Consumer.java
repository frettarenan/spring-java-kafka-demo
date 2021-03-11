package br.com.renanfretta.kafka.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@KafkaListener(topics = Producer.TOPIC, groupId = Producer.GROUPID)
	public void consume(String message) throws IOException {
		logger.info(String.format("#### -> Consumer > message -> %s", message));
		try {
			// Só vai receber outra mensagem quando terminar o processamento da mensagem atual
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
