package io.kowsu;

import io.kowsu.designprinciples.Singleton;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SingletonTest {


    @Test
    public void eagerInitTest() {
        Singleton instance1 = Singleton.getInstance();
        assertEquals(Thread.currentThread().getName(), instance1.getName());
        Singleton instance2 = Singleton.getInstance();
        assertEquals(Thread.currentThread().getName(), instance2.getName());
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @Test
    public void breakEagerSingletonPattern() throws Exception {
        Class<?> aClass = Class.forName(Singleton.class.getName());
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        assertThrows(UnsupportedOperationException.class, () -> declaredConstructor.newInstance(), "Operation not permitted.");
    }
}
