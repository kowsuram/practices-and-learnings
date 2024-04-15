package io.kowsu.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedEventListener {

    @EventListener
    public void orderListener(Order order) {
       display(order);
    }


    private void display(Order order) {
        System.out.printf("OrderId %s, Order Type  %s, Order Placed Date %s \n", order.orderId(),
                order.orderType(), order.orderId());
    }
}
