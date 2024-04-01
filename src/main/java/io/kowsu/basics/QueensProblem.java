package io.kowsu.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class QueensProblem {

    public static void main(String[] args) {
        int cols = 4, rows = 4;
        Set<Integer> rowPlacements = new HashSet<>();
        Set<Integer> colPlacements = new HashSet<>();
        String queens[][] = new String[rows][cols];
        int size = queens.length-1;

        //check for there will be no left side "Q" placement
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!rowPlacements.contains(row) && !colPlacements.contains(col)
                && positiveDiag(queens, row, col, size)
                && negativeDiag(queens, row, col, size)) {
                    rowPlacements.add(row);
                    colPlacements.add(col);
                    queens[row][col] = "Q";
                } else {
                    queens[row][col] = "-";
                }

            }
        }
        display(queens);
    }

    public static boolean positiveDiag(String[][] queens, int row, int col, int size) {
        if (
                (row + 1 <= size)
                && (col + 1 <= size)
                && queens[row+1][col+1] != null
                && !queens[row+1][col+1].equals("Q")
        ) {
            return true;
        }
        return false;
    }

    public static boolean negativeDiag(String[][] queens, int row, int col, int size) {
        if (
                (row - 1 <= size && row - 1 >= 0)
                && (col - 1 <= size && col - 1 >= 0)
                && !queens[row-1][col-1].equals("Q")) {
            return true;
        }
        return false;
    }


//    public static void main(String[] args) throws IOException {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("No.of rows");
//        int rows = Integer.parseInt(reader.readLine());
//        System.out.println("No.of columns");
//        int cols = Integer.parseInt(reader.readLine());
//        String[][] queens = new String[rows][cols];
//        System.out.printf("Enter data for %d X %d matrix \n", rows, cols);
//
//        for (int i = 0; i < rows; i++) {
//            String data = reader.readLine();
//            String[] split = data.split(",");
//            for (int j = 0; j < cols; j++) {
//                queens[i][j] = split[j];
//            }
//        }
//        display(queens);
//    }

    private static void display(String[][] queens) {
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                System.out.print(queens[i][j] + " ");
            }
            System.out.println();
        }
    }
}


