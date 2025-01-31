package codingbat.Array3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingBatFix34 {
    public static void main(String[] args) {

        /*Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4.
        Do not move the 3's, but every other number may move. The array contains the same number of 3's and 4's, every 3 has a number after it that
        is not a 3, and a 3 appears in the array before any 4.


        fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
        fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
        fix34([3, 2, 2, 4]) → [3, 4, 2, 2]*/

        int[] arr = new int[]{1, 3, 1, 4, 4, 5, 3};
        Arrays.stream(fix34(arr)).forEach(System.out::println);
    }

    static int[] fix34(int[] nums) {
        List<Integer> position = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] == 4){
                position.add(i);
            }
        }
        int count = 0;
        for (int j = 0 ; j < nums.length-1 ;j++){
            if (nums[j] == 3 && nums[j+1] !=4){
                int temp = nums[j+1];
                nums[j+1] = 4;
                nums[position.get(count)] = temp;
                count++;
            }
        }
        return nums;
    }
}
