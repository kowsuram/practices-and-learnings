package io.kowsu.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderPlacedEventProducer {
    @Autowired
    ApplicationEventPublisher publisher;

    public void placeOrder(Order order) {
        publisher.publishEvent(order);
    }
}
