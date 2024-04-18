package io.kowsu.algos;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class QueueImpl<T> {


    private final LinkedList<T> store = new LinkedList<>();


    public boolean offer(T t) {
        return store.add(t);
    }

    public T poll() {
        return store.pollFirst();
    }

    public T element() {
        return store.getFirst();
    }

    public T peek() {
        return store.peek();
    }


    @Override
    public String toString() {
        return store.stream().map(String::valueOf).collect(Collectors.joining("->"));
    }

    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl();
        queue.offer(100);
        queue.offer(200);
        queue.offer(300);
        queue.offer(400);
        System.out.println(STR."after adding 100,200,300,400 data \{queue}");

        System.out.println(STR."poll \{queue.poll()}");

        System.out.println(STR."after poll data \{queue}");
        queue.offer(500);
        System.out.println(STR."after adding 500 data \{queue}");
        queue.element();
        queue.element();
        queue.element();
        queue.element();
        queue.element();
        queue.element();
        System.out.println(STR."after element 6 times data \{queue}");
        queue.peek();
        queue.peek();
        queue.peek();
        System.out.println(STR."after 3 peeks \{queue}");
    }


}
