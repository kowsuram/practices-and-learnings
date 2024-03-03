package io.kowsu.dp.behavioral;

public class StrategyPattern {

    public static void main(String[] args) {
        new Context(new BubbleSort()).sort();
        new Context(new MergeSort()).sort();
        new Context(new RadixSort()).sort();
    }
}

class Context {

    private ISort sort;

    public Context(ISort sort) {
        this.sort = sort;
    }

    public void sort() {
        this.sort.sort(new int[]{1,2,3});
    }
}

interface ISort{
    void sort(int[] a);
}

class BubbleSort implements ISort {
    @Override
    public void sort(int[] a) {
        System.out.println("Sorting the numbers using bubble Sort");
    }
}

class MergeSort implements ISort {
    @Override
    public void sort(int[] a) {
        System.out.println("Sorting the numbers using merge Sort");
    }
}


class RadixSort implements ISort {
    @Override
    public void sort(int[] a) {
        System.out.println("Sorting the numbers using radix Sort");
    }
}