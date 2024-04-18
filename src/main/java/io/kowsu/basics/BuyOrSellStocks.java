import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

void main() {
//    maxProfit(new int[]{7, 1, 3, 5, 6, 2});
//    maxProfit(new int[]{10, 9, 8, 7, 6, 5});
//    System.out.println(STR."find duplicates \{containsDuplicates(new int[]{1, 2, 34, 2, 1})}");

    System.out.println(STR."product of array \{Arrays.toString(productOfArrayExceptItSelf(new int[]{1, 2, 3, 4}))}");
}


/**
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * @param nums
 * @return
 */
int[] productOfArrayExceptItSelf(int[] nums) {

    //To archive O(n), first write your programing in O(n*n)
    // then find a way to achieve O(2n) loop,
    // try to decrease memory consuming by only using one array then you will having O(n),

    int res[] = new int[nums.length];
    Arrays.fill(res, 1);

    for (int i = 0; i < nums.length; i++) { //O(n)
        for (int j = 0; j < nums.length; j++) { //O(n)
            if (i != j)
                res[i] = res[i] * nums[j];
        }
    }


    for (int i = 0; i < nums.length; i++) {

    }

    return res; //O(n^2)
}


boolean containsDuplicates(int nums[]) {
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            map.put(nums[i], map.get(nums[i]) + 1);
        } else {
            map.put(nums[i], 1);
        }
    }
    return map.values().stream().filter(a -> (a > 1)).findAny().isPresent();
}


void maxProfit(int nums[]) {
    int max_profit = 0, buy = nums[0], day_num = 0;

    for (int i = 1; i < nums.length; i++) {
        if (buy > nums[i]) {
            buy = nums[i];
        } else if ((nums[i] - buy) > max_profit) {
            max_profit = nums[i] - buy;
            day_num = i;
        }
    }

    System.out.println(STR."max profit \{max_profit} if sells on \{day_num + 1} day");
}

