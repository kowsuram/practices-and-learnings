package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    @created February/28/2024 - 11:29 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
 class RecordTest {

    @Test
    void recordTest() {
        UserCreatedEvent ram = new UserCreatedEvent("RAM");
        assertEquals(ram.name(), "RAM");
    }

}

record UserCreatedEvent(String name) {}
