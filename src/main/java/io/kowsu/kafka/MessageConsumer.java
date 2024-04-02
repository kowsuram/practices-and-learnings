package io.kowsu.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
    @created March/26/2024 - 7:20 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

@Component
public class MessageConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
