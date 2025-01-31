package codingbat.array2;

import java.util.Arrays;

public class CodingBatEvenOdd {
    public static void main(String[] args) {

        /*Return an array that contains the exact same numbers as the given array, but rearranged so that all the even numbers come
        before all the odd numbers. Other than that, the numbers can be in any order. You may modify and return the given array, or make a new array.


                evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
        evenOdd([3, 3, 2]) → [2, 3, 3]
        evenOdd([2, 2, 2]) → [2, 2, 2]*/

        int[] arr = new int[]{1, 0, 1, 0, 0, 1, 1};
        Arrays.stream(evenOdd(arr)).forEach(System.out::println);

    }

    static int[] evenOdd(int[] nums) {
        int[] newArr = new int[nums.length];
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                newArr[count] = num;
                count++;
            }

        }
        for (int num : nums) {
            if (num % 2 != 0) {
                newArr[count] = num;
                count++;
            }
        }
        return newArr;
    }

}
