package codingbat.array1;

import java.util.Arrays;

public class CodingBatMakeEnds {
    public static void main(String[] args) {


        /*Given an array of ints, return a new array length 2 containing the first and last elements from the original array.
        The original array will be length 1 or more.


        makeEnds([1, 2, 3]) → [1, 3]
        makeEnds([1, 2, 3, 4]) → [1, 4]
        makeEnds([7, 4, 6, 2]) → [7, 2]*/

        int[] nums = new int[]{7, 4, 6, 2};
        Arrays.stream(makeEnd(nums)).forEach(System.out::println);

    }

    static int[] makeEnd(int[] nums){
        int[] arr = new int[2];
        arr[0] = nums[0];
        arr[1] = nums[nums.length-1];

        return arr;
    }
}
