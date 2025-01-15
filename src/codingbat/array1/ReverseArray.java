package codingbat.array1;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        /*Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.


        reverse3([1, 2, 3]) → [3, 2, 1]
        reverse3([5, 11, 9]) → [9, 11, 5]
        reverse3([7, 0, 0]) → [0, 0, 7]*/

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        reversearr(arr);

    }

    public static void reversearr(int[] nums) {
        if (nums.length > 0) {
            int[] reversearr = new int[nums.length];
            int count = 0;
            for (int i = nums.length-1; i >= 0; i--) {
                reversearr[count] = nums[i];
                count++;
            }
            Arrays.stream(reversearr).forEach(System.out::println);
        }
    }

}
