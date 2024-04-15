package io.kowsu.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Request {

    private String requestId = UUID.randomUUID().toString();
    private String host;
}
