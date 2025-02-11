package array;

import java.util.Arrays;

public class LongestIncreasingSubArray {
    public static void main(String[] args) {
        /*Given an array of integers, find the longest contiguous subarray whose elements are increasing, that is, the elements
        following the preceding elements in the subarray must be greater than them.
                Example:

        Array = [1,2,5, 6, 3, 0, 7, 8, 9, 1, 2]

        Output: 0 7 8 9*/

        int[] arr = new int[]{1, 2, 5, 6, 3, 0, 2, 3, 1, 2};
        subArray(arr);

    }

    static void subArray(int[] array) {

        int[] subArr = new int[2];
        int startPos = 0, endPos = 0;
        int maxLength = 0;
        int j = 0;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] < array[i + 1]) {
                startPos = i;
                for (j = i + 1; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        break;
                    }
                }
                subArr[0] = startPos;
                subArr[1] = j;
                if (subArr[1] - subArr[0] > maxLength) {
                    endPos = subArr[0];
                    maxLength = subArr[1] - subArr[0];
                }
                i = j;
            }
        }
        for (int i = endPos ; i <= endPos + maxLength ; i++){
            System.out.println(array[i]);
        }
    }

}
