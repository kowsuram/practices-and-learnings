package io.kowsu.algos.back_tracking;

/*
    @created April/02/2024 - 9:11 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void calcSubset(List<Integer> list,
                                  List<List<Integer> > res,
                                  List<Integer> subset,
                                  int index)
    {
        // Add the current subset to the result list
        res.add(new ArrayList<>(subset));

        // Generate subsets by recursively including and
        // excluding elements
        for (int i = index; i < list.size(); i++) {
            // Include the current element in the subset
            subset.add(list.get(i));

            // Recursively generate subsets with the current
            // element included
            calcSubset(list, res, subset, i + 1);

            // Exclude the current element from the subset
            // (backtracking)
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer> >
    subsets(List<Integer> A)
    {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer> > res = new ArrayList<>();

        int index = 0;
        calcSubset(A, res, subset, index);

        return res;
    }

    // Driver code

    public static void main(String[] args)
    {
        List<Integer> array = List.of(1, 2, 3);
        List<List<Integer> > res = subsets(array);

        // Print the generated subsets
        for (List<Integer> subset : res) {
            System.out.print("{");
            for (Integer num : subset) {
                System.out.print(num + " ");
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
