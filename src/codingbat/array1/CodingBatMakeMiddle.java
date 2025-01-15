package codingbat.array1;

import java.util.Arrays;

public class CodingBatMakeMiddle {
    public static void main(String[] args) {
        /*Given an array of ints of even length, return a new array length 2 containing
        the middle two elements from the original array. The original array will be length 2 or more.


        makeMiddle([1, 2, 3, 4]) → [2, 3]
        makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
        makeMiddle([1, 2]) → [1, 2]*/

        int[] arr2 = new int[]{1,2,3,4,5,6,7};
        Arrays.stream(makeMiddle(arr2)).forEach(System.out::println);

    }

    static int[] makeMiddle(int[] nums) {
        int middlePointer = (int) (Math.ceil((double) nums.length / 2) - 1);
        int[] returnArr = new int[2];
        if (nums.length > 1) {
            returnArr[0] = nums[middlePointer];
            returnArr[1] = nums[middlePointer + 1];
        }
        return returnArr;
    }
}
