package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RecordsTest {

    record User(String name) {
    }

    record UserCreatedEvent(User user) {
    }

    record UserDeletedEvent(String name) {
    }

    String respond(Object o) {
        return switch (o) {
            case UserCreatedEvent(var user) -> String.format("user created with name %s", user.name());
            case UserDeletedEvent(var name) -> String.format("user deleted with name %s", name);
            default -> throw new UnsupportedOperationException("event not supported");
        };
    }


    @Test
    void respondTest() {

        assertThat(
                respond(new UserCreatedEvent(new User("Ram")))
        ).isEqualTo("user created with name Ram");

        assertThat(
                respond(new UserDeletedEvent("Ram"))
        ).isEqualTo("user deleted with name Ram");

        assertThatThrownBy(
                () -> respond(new User("XYZ"))
        )
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("event not supported");
    }

}



