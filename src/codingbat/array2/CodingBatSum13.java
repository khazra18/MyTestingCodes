package codingbat.array2;

public class CodingBatSum13 {
    public static void main(String[] args) {
        /*Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky,
                so it does not count and numbers that come immediately after a 13 also do not count.


        sum13([1, 2, 2, 1]) → 6
        sum13([1, 1]) → 2
        sum13([1, 2, 2, 1, 13]) → 6*/

        int[] arr = new int[]{1, 2, 2, 1, 13,14};
        System.out.println(sum13(arr));

    }

    static int sum13(int[] nums) {
        int sum =0;
        boolean skipNext = false;
        for (int num : nums) {
            if (num == 13) {
                skipNext = true;
                continue;
            }
            if (skipNext) {
                skipNext = false;
                continue;
            }
            sum += num;
        }
        return sum;
    }

}
