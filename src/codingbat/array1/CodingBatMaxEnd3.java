package codingbat.array1;

import java.util.Arrays;

public class CodingBatMaxEnd3 {
    public static void main(String[] args) {


        /*Given an array of ints length 3, figure out which is larger, the first or last element in the array, and set all the other elements to be that value. Return the changed array.

        maxEnd3([1, 2, 3]) → [3, 3, 3]
        maxEnd3([11, 5, 9]) → [11, 11, 11]
        maxEnd3([2, 11, 3]) → [3, 3, 3]*/

        int[] arr = new int[]{10, 2, 3, 4, 5, 6};
        maxEnd3(arr);

    }

    static void maxEnd3(int[] num){
        int temp = Math.max(num[0], num[num.length - 1]);
        Arrays.fill(num, temp);
        Arrays.stream(num).forEach(System.out::println);
    }
}
