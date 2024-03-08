package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoCloseableTest {


    record Person(String name) {}

    class PersonStore implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("closing the person store here.");
        }

        public List<Person> getPersonObjects() {
            System.out.println("returning person objects is done");
            return Arrays.asList(new Person("Ram"), new Person("Vikram"));
        }
    }

    @Test
    void autoCloseableTest() {
        try(PersonStore personStore = new PersonStore()) {
            assertThat(personStore.getPersonObjects()).hasSize(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
