package io.kowsu.algos;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    @created April/01/2024 - 10:47 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class PriorityDequeExamples {

    public static void main(String[] args) {
        Queue<Job> queue = new PriorityQueue<>((a,b) -> {
            return a.urgency().getValue() > b.urgency().getValue() ? 1 : -1;
        });

        queue.add(new Job(2, Urgency.LOW));
        queue.add(new Job(1, Urgency.HIGH));
        queue.add(new Job(4, Urgency.MEDIUM));
        queue.add(new Job(0, Urgency.LOW));
        queue.add(new Job(5, Urgency.MEDIUM));

        while (!queue.isEmpty()) {
            System.out.println(STR."peek \{queue.peek()}");
        }
    }
}


record Job(int jobId, Urgency urgency){}

enum Urgency {
    HIGH(1), MEDIUM(2), LOW(3);
    int type;

    Urgency(int type) {
        this.type = type;
    }

    public int getValue() {
        return type;
    }
}
