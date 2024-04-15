package io.kowsu.designprinciples;

public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
        if(instance != null) {
            throw new UnsupportedOperationException("Cannot initialize the object.");
        }
    }

    public static Singleton getInstance() {
        return instance;
    }

    public String getName() {
        return Thread.currentThread().getName();
    }


}



