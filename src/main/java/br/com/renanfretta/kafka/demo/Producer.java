package br.com.renanfretta.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    
    public static final String TOPIC = "teste";
    
    public static final String GROUPID = "groupId";
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producer > message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
    
}
