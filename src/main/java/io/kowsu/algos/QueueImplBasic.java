package io.kowsu.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueueImplBasic<T> {


    private List<T> list = new ArrayList<>();

    public QueueImplBasic() {
    }

    public void offer(T data) {
        list.add(data);
    }

    private void checkIsEmpty() {
        if (list.isEmpty()) throw new RuntimeException("queue is empty");
    }

    public T element() {
        checkIsEmpty();
        return list.get(0);
    }

    public T peek() {
        checkIsEmpty();
        return list.get(0);
    }

    public T poll() {
        return list.isEmpty() ? null : list.remove(0);
    }

    @Override
    public String toString() {
        if (list.isEmpty())
            return "[]";
        return list.stream().map(String::valueOf).collect(Collectors.joining("->"));
    }

    public static void main(String[] args) {
        QueueImplBasic queue = new QueueImplBasic();
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
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(STR."after 5 polls \{queue}");
    }
}
