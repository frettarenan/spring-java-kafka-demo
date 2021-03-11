package br.com.renanfretta.kafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	@Autowired
    private Producer producer;

    @GetMapping(value = "/publish/{message}")
    public void sendMessageToKafkaTopic(@PathVariable String message) {
        this.producer.sendMessage(message);
    }
    
}
