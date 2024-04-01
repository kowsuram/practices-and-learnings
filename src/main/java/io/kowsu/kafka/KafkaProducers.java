package io.kowsu.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;

import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.Future;

public class KafkaProducers {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("enable.idempotence", "true"); // Enable idempotent producer
        properties.put("transactional.id", "my-transactional-id"); // Unique transactional ID

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        try {
            // Initialize transaction
            producer.initTransactions();

            // Begin the transaction
            producer.beginTransaction();

            // Send messages within the transaction
            ProducerRecord<String, String> record1 = new ProducerRecord<>("orders", "key1", "value1");
            ProducerRecord<String, String> record2 = new ProducerRecord<>("payments", "key2", "value2");

            Future<RecordMetadata> send = producer.send(record1);
            System.out.println("send result " + send.get());
            System.out.println("orders topic message sent");
            Thread.sleep(1000);
//            if(true)
//                throw new RuntimeException("Something went wrong after orders");
            producer.send(record2);

            // Commit the transaction
            producer.commitTransaction();
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            producer.close();
        } catch (KafkaException e) {
            producer.abortTransaction();
        } finally {
            producer.close();
        }
    }
}
