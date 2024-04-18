package io.kowsu.algos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StackArrayDs<T> {


    private static final int iSize = 4;
    private int top = -1, len;

    private T[] uds;

    public StackArrayDs(Class<T> type) {
        uds = (T[]) Array.newInstance(type, iSize);
        len = uds.length;
    }


    public void push(T t) {
        if (top < len) {
            uds[top] = t;
            top++;
        } else {
            throw new RuntimeException("stack is full");
        }
    }

    public void pop() {
        if (top < len) {
            uds[top] = null;
            top--;
        }
    }

    public boolean empty() {
        return top < 0;
    }

    public T top() {
        if (top < len) {
            return uds[top];
        } else {
            throw new RuntimeException("stack is full");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(uds);
    }

    public static void main(String[] args) {
        StackArrayDs<Integer> ds = new StackArrayDs(Integer.class);
        ds.push(100);
        ds.push(200);
        ds.push(300);
        System.out.println(STR."after adding 100, 200, 300 \{ds}");
        ds.pop();
        ds.pop();
        System.out.println(STR."after pop of 100, 200 \{ds}");
        ds.push(500);
        ds.push(600);

        System.out.println(STR."after adding 500, 600 \{ds}");

        ds.push(700);
        ds.push(800);
        System.out.println(STR."after adding 700, 800 \{ds}");
    }

}
