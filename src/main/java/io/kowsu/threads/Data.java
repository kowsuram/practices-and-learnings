package io.kowsu.threads;

public class Data {

    boolean isTransfer = true;

    public void send() {

        while (isTransfer) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        isTransfer = true;
        notifyAll();
    }

    public void receive() {

        while (!isTransfer) {
            try {
                this.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
