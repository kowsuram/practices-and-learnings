package io.kowsu.events;

import org.springframework.context.ApplicationEvent;

public class OrderPlacedEvent extends ApplicationEvent {
    public OrderPlacedEvent(Order source) {
        super(source);
    }
}
