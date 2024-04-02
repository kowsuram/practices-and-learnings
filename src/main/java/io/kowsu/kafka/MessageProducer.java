package io.kowsu.kafka;

/*
    @created March/26/2024 - 7:18 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Component
@AllArgsConstructor
public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) throws Exception {
        CompletableFuture<SendResult<String, String>> sendResponse = kafkaTemplate.send(topic, message);
//        SendResult<String, String> sendResult = sendResponse.get();
//        System.out.println(sendResult.getRecordMetadata());

        sendResponse.whenCompleteAsync((sr, v) -> {
            System.out.println("Success " + sr.getRecordMetadata());
            if(Objects.nonNull(v)) {
                System.out.println("Failure " + v.getMessage());
            }
        });

    }
}
