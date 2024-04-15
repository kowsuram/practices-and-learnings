package io.kowsu.threads;

public class Task {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Shared());
        t1.setName("t1");
        Thread t2 = new Thread(new Shared());
        t1.setName("t2");

        t1.start();
        t2.start();
    }

}


class Shared implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Waiting thread : " + Thread.currentThread().getName());
            wait(1000);
            System.out.println("Wait completed : " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifyAll();
    }
}
