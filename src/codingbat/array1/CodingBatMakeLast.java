package codingbat.array1;

import java.util.Arrays;

public class CodingBatMakeLast {
    public static void main(String[] args) {
        /*Given an int array, return a new array with double the length where its last element is the same as the original array,
        and all the other elements are 0. The original array will be length 1 or more. Note: by default, a new int array contains all 0's.

        makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
        makeLast([1, 2]) → [0, 0, 0, 2]
        makeLast([3]) → [0, 3]*/

        int[] nums = new int[]{1};
        Arrays.stream(makeLast(nums)).forEach(System.out::println);

    }

    static int[] makeLast(int[] nums){
        int[] arr = new int[nums.length*2];
        if (nums.length >= 1){
            int lastValue = nums[nums.length-1];
            for (int i = 0 ; i < arr.length ; i++) {
                arr[i] = 0;
                if (i == arr.length - 1) {
                    arr[i] = lastValue;
                }
            }
        }
        return arr;
    }
}
