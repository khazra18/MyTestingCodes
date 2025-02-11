package codewars;

import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayElementParity {

    public static void main(String[] args) {

        //https://www.codewars.com/kata/5a092d9e46d843b9db000064/train/java

        /*In this Kata, you will be given an array of integers whose elements have both a negative and a positive value,
                except for one integer that is either only negative or only positive. Your task will be to find that integer.

        Examples:

        [1, -1, 2, -2, 3] => 3*/



    }

    public static int solve(int [] arr){
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            // If the opposite is in the set, remove it, otherwise add the current number
            if (set.contains(-num)) {
                set.remove(-num);
            } else {
                set.add(num);
            }
        }
        // The remaining element in the set is the answer
        return set.iterator().next();

    }

    //alternatives
    //return Arrays.stream(arr).distinct().sum();
}
