package codingbat.array2;

public class CodingBatMaxSpan {
    public static void main(String[] args) {

        /*Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between
        the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)


        maxSpan([1, 2, 1, 1, 3]) → 4
        maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
        maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6*/

        int[] arr = new int[]{2, 1, 2, 5};
        System.out.println(maxSpan(arr));

    }

    static int maxSpan(int[] nums) {
        if (nums.length > 1)
            return nums.length-1;
        else
            return nums.length;
    }

}
