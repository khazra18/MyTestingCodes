package codewars;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PokerHandIsFlushed {
    public static void main(String[] args) {

        //https://www.codewars.com/kata/5acbc3b3481ebb23a400007d/train/java

        /*Determine if the poker hand is flush, meaning if the five cards are of the same suit.

        Your function will be passed a list/array of 5 strings, each representing a poker card in the format "5H" (5 of hearts),
        meaning the value of the card followed by the initial of its suit (Hearts, Spades, Diamonds or Clubs). No jokers included.

        Your function should return true if the hand is a flush, false otherwise.

                The possible card values are 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A

        Examples
                ["AS", "3S", "9S", "KS", "4S"]  ==> true

                ["AD", "4S", "7H", "KS", "10S"] ==> false*/

        System.out.println(CheckIfFlush(new String[]{"AS", "3S", "10S", "KS", "4S" }));

    }

    public static boolean CheckIfFlush(String[] cards) {

        Set<String> duplicateSet = Arrays.stream(cards).map(s -> {
            if (s.length() == 3) {
                return s.substring(2, 3);
            } else {
                return s.substring(1);
            }
        }).collect(Collectors.toSet());
        return duplicateSet.size() == 1;
    }
}
