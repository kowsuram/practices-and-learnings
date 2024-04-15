package io.kowsu.events;

import java.time.LocalDate;

public record Order(String orderId, String orderType, LocalDate date) {
}
