package codingbat.Array3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingBatFix45 {
    public static void main(String[] args) {
        /*(This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers as the given array,
                but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but every other number may move.
        The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. In this version,
            5's may appear anywhere in the original array.


        fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
        fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
        fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]*/

        int[] arr = new int[]{4, 5, 4, 1, 5};
        Arrays.stream(fix45(arr)).forEach(System.out::println);

    }

    static int[] fix45(int[] nums) {
        List<Integer> position = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i== 0 && nums[i] == 5){
                position.add(i);
            }else if (nums[i] == 5 && nums[i-1] !=4){
                position.add(i);
            }
        }
        int count = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] == 4 && nums[j + 1] == 5) {
                continue;
            }
            if (nums[j] == 4 && nums[j + 1] != 4) {
                int temp = nums[j + 1];
                nums[j + 1] = 5;
                nums[position.get(count)] = temp;
                count++;
            }
        }
        return nums;
    }

}
