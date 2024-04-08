package io.kowsu.algos.recursion;

/*
    @created April/03/2024 - 3:40 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class RecursionExamples {


    public void takeBall(int i) {
        if (i <= 0) {
            System.out.println("nothing left");
            return;
        } else {
            System.out.printf("%d balls left \n", i);
            i = i - 1;
        }
        takeBall(i);
    }

    //0,1,1,2,3,5,....
    public void fibnocciSeries(int prev, int current, int len) {
        int next = current + prev;
        prev = current;
        current = next;
        System.out.print(next + " ");
        if (len >= 0) {
            fibnocciSeries(prev, current, len - 1);
        }
    }

    public int factorial(int num) {
        if (num == 0 || num == 1)
            return 1;
        return num * factorial(num - 1);
//        return num;
    }

    public void tables(int table, int from, int to) {
        if (from <= to) {
            System.out.printf("%d X %d = %d \n", table, from, (table * from));
            tables(table, from + 1, to);
        }
    }

    public String palindrome(String word, String result, int len) {
        if (len == 0) {
            return result.concat(String.valueOf(word.charAt(len)));
        }
        return result.concat(palindrome(word, result, len-1));
    }

    public int sumOfDigits(int num) {
        return 0;
    }



    public static void main(String[] args) {
        RecursionExamples recursionExamples = new RecursionExamples();
//        recursionExamples.takeBall(10);
//        System.out.printf("%d %d ", 0, 1);
//        recursionExamples.fibnocciSeries(0,1,5);

//        int res = recursionExamples.factorial(5);
//        System.out.printf("result %d", res);

//        recursionExamples.tables(13, 6, 9);


//        String palindrome = recursionExamples.palindrome("MADAS", "", 5);
//        System.out.printf("result %s", palindrome);
//
        System.out.println(1/10);

    }
}
