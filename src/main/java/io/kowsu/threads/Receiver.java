package io.kowsu.threads;

public class Receiver implements Runnable {

    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.receive();
    }
}
