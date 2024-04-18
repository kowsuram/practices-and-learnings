package io.kowsu.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stack<T> {
    private List<T> uds;
    private int size, top = -1;

    public Stack(int size) {
        this.size = size;
        uds = new ArrayList<>(size);
    }

    private void checkInternals() {
        if (size <= top) {
            throw new RuntimeException("Stack is full");
        }
    }

    private void checkIfEmpty() {
        if (uds.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
    }

    public void push(T t) {
        checkInternals();
        uds.add(t);
        top++;
    }


    public void pop() {
        checkIfEmpty();
        uds.remove(uds.size() - 1);
    }

    public T top() {
        checkIfEmpty();
        return uds.get(uds.size() - 1);

    }

    public boolean empty() {
        return uds.isEmpty();
    }

    public String toString() {
        return uds.stream().map(String::valueOf).collect(Collectors.joining("->"));
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);

        System.out.println(STR."after adding 100, 200, 300, 400 \{stack}");
        stack.pop();
        System.out.println(STR."after pop \{stack}");
        System.out.println(STR."is empty \{stack.empty()}");
        stack.push(500);
        stack.push(600);
        stack.push(600);
        System.out.println(STR."after adding 500,600 \{stack}");
        System.out.println(STR."top element \{stack.top()}");
    }
}
