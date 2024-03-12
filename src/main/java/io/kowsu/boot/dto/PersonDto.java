package io.kowsu.boot.dto;

import java.io.Serializable;

public record PersonDto(String name, String email) implements Serializable {
}
