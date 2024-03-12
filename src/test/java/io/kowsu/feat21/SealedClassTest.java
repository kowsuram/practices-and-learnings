package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    @created February/28/2024 - 11:29 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
class SealedClassTest {

    String communicate(Animal animal) {
        return switch (animal) {
            case Dog dog -> dog.sounds();
            case Cat cat -> cat.sounds();
        };
    }


    @Test
    void communicationTest() {
        assertEquals("meow", communicate(new Cat()));
        assertEquals("bark", communicate(new Dog()));
    }
}

sealed interface Animal {
    
}

final class Dog implements Animal {
     public String sounds() {
        return "bark";
    }
}

final class Cat implements Animal {
     public String sounds() {
        return "meow";
    }
}

