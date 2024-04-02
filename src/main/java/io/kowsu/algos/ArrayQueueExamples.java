package io.kowsu.algos;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
    @created April/01/2024 - 10:03 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class ArrayQueueExamples {

    //no size limit
    private static final Queue<String> transactions = new ArrayDeque<>();
    private static Integer producerSleepTimer = 2;
    private static Integer consumerSleepTimer = 3;

    public static void publisher() throws InterruptedException {
        //publisher
        while (true) {
            String uid = UUID.randomUUID().toString();
            transactions.add(uid);
            System.out.printf("Producer >>>>>>>>>>> Message with id %s \n", uid);
            TimeUnit.SECONDS.sleep(producerSleepTimer);
        }
    }

    public static void consumer() throws InterruptedException {
        //consumer
        while (true) {
            System.out.printf("Consumer >>>>>>>>>>> Message received with id %s \n", transactions.poll());
            TimeUnit.SECONDS.sleep(consumerSleepTimer);
        }
    }

    public static void monitor() throws InterruptedException {
        //consumer
        while (true) {
            System.out.printf("Monitor >>>>>>>>>>> Queue size %d \n", transactions.size());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void scale() throws InterruptedException {
        //consumer
        while (true) {
            if (transactions.size() > 5) {
                consumerSleepTimer = 1;
                producerSleepTimer = 5;
            } else {
                consumerSleepTimer = 5;
                producerSleepTimer = 1;
            }
            System.out.printf("Scale >>>>>>>>>>> consumer sleep %d, producer sleep %d \n", consumerSleepTimer, producerSleepTimer);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                publisher();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                monitor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                scale();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
