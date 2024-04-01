package io.kowsu.algos.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest implements Sort {

    @Override
    public int[] sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                System.out.printf("i : %d, j: %d => %s \n", i, j, Arrays.toString(a));
            }
            System.out.println("After inner iteration : " + Arrays.toString(a));
        }
        return a;
    }

    @Override
    public int[] optimizedSort(int[] a) {
        int len = a.length;
        boolean swapped;
        for (int i = 0; i < len; i++) {
            swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                    System.out.printf("i : %d, j : %d, (j+1): %d => %s \n", i,  j, j+1, Arrays.toString(a));
                }
            }
            System.out.println("After inner iteration : " + Arrays.toString(a));
            if (!swapped) {
                break;
            }
        }
        return a;
    }

    @Test
    void test() {
        int[] sort = sort(new int[]{4, 2, 1, 8, 7});
        assertEquals(
                Arrays.toString(new int[]{1, 2, 4, 7, 8}),
                Arrays.toString(sort)
        );
    }

    @Test
    void optimizedTest() {
        int[] sort = optimizedSort(new int[]{4, 2, 1, 8, 7});
        assertEquals(
                Arrays.toString(new int[]{1, 2, 4, 7, 8}),
                Arrays.toString(sort)
        );
    }
}
