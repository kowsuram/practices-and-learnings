package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SealedTypesTest {

    public  String findCommunication(Animal animal) {
        return switch (animal) {
            case Dog dog -> dog.communicate();
            case Cat cat -> cat.communicate();
        };
    }

    @Test
    void findCommunicationTest() {
        assertThat(findCommunication(new Dog())).isEqualTo("bark");
        assertThat(findCommunication(new Cat())).isEqualTo("meow");
    }
}

sealed interface Animal permits Cat, Dog  {
    String communicate();
}

final class Cat implements Animal {
    @Override
    public String communicate() {
        return "meow";
    }
}

final class Dog implements Animal {
    @Override
    public String communicate() {
        return "bark";
    }
}