package codingbat.array1;

import java.util.Arrays;

public class CodingBatBiggerTwo {
    public static void main(String[] args) {

        /*Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array.
                Return the array which has the largest sum. In event of a tie, return a.


                biggerTwo([1, 2], [3, 4]) → [3, 4]
        biggerTwo([3, 4], [1, 2]) → [3, 4]
        biggerTwo([1, 1], [1, 2]) → [1, 2]*/

        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{2, 3, 4};
        Arrays.stream(biggerTwo(arr1, arr2)).forEach(System.out::println);
    }

    static int[] biggerTwo(int[] a, int[] b) {
        int sum_a = 0, sum_b = 0;
        if (a.length > 0) {
            sum_a = Arrays.stream(a).sum();
        }
        if (b.length > 0) {
            sum_b = Arrays.stream(b).sum();
        }
        if (sum_a == sum_b)
            return a;
        else
            return sum_a > sum_b ? a : b;
    }
}
