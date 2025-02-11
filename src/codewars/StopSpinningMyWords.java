package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StopSpinningMyWords {
    public static void main(String[] args) {


       /* Write a function that takes in a string of one or more words, and returns the same string, but with all words that have five or more letters
    reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more
        than one word is present.

        Examples:

        "Hey fellow warriors"  --> "Hey wollef sroirraw"
        "This is a test        --> "This is a test"
        "This is another test" --> "This is rehtona test"*/


        System.out.println(spinWords("Hey fellow warriors"));
    }

    static String spinWords(String sentence) {

        return Arrays.stream(sentence.split(" ")).map(s -> {
            if (s.length() > 4) {
                return new StringBuilder(s).reverse();
            } else return s;
        }).collect(Collectors.joining(" "));

    }
}
