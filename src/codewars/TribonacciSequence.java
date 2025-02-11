package codewars;

import java.util.Arrays;

public class TribonacciSequence {

    public static void main(String[] args) {

        //https://www.codewars.com/kata/556deca17c58da83c00002db/train/java

        /*Well met with Fibonacci bigger brother, AKA Tribonacci.
                As the name may already reveal, it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers of the sequence to
        generate the next. And, worse part of it, regrettably I won't get to hear non-native Italian speakers trying to pronounce it :(

        So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), we have this sequence:

        [1, 1 ,1, 3, 5, 9, 17, 31, ...]*/

        Arrays.stream(tribonacci(new double[]{1, 1, 1}, 10)).forEach(System.out::println);
    }

    static double[] tribonacci(double[] s, int n) {
        double[] returnArr = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < 3) {
                returnArr[i] = s[i];
            } else {
                returnArr[i] = returnArr[i - 1] + returnArr[i - 2] + returnArr[i - 3];
            }
        }
        return returnArr;
    }
}
