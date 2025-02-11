package codewars;

public class TransformToPrime {
    public static void main(String[] args) {

        //https://www.codewars.com/kata/5a946d9fba1bb5135100007c

        /*Task
        Given a list of positive integers, determine the minimum non-negative integer that needs to be inserted so that the sum of all elements becomes
        a prime number.

                Notes
        The list will always have at least 2 elements.
                All elements will be positive integers (n > 0).
                The list may contain duplicate values.
                The new sum must be the closest prime number that is greater than or equal to the current sum.
        Examples
                [3, 1, 2] ==> Should return 1
        Explanation: The sum is 6
        The closest prime greater than or equal to 6 is 7
        We need to add 1 to make the sum 7 (a prime)*/


        System.out.println(minimumNumber(new int[]{5,2}));
    }

    public static int minimumNumber(int[] numbers) {

        int sum = 0, positiveCount = 0;
        for (int i : numbers) {
            sum = sum + i;
        }
        boolean positiveFlag = false;
        while (!positiveFlag) {

            positiveFlag = isPrime(sum + positiveCount);
            positiveCount++;

        }

        return --positiveCount;

    }

    public static boolean isPrime(int num) {
        System.out.println(" -------------- " + num);
        if (num == 1 || num % 2 == 0) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
