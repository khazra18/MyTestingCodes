package StringProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class UncommonCharInBothString {
    public static void main(String[] args) {
        /*two input string let say "rahul" and "sourabh" i need to find the uncommon characters in both strings for example in
        above scenario the uncommon characters are l,b,o,s*/

        System.out.println(uncommonStr("rahul","sourabh"));

    }

    static String[] uncommonStr(String input1,String input2){

        Set<String> input1Set = Arrays.stream(input1.split("")).collect(Collectors.toSet());
        Set<String> input2Set = Arrays.stream(input2.split("")).collect(Collectors.toSet());

        Set<String> unCommonSet = new HashSet<>();
        for (String s: input1Set){
            if (!input2Set.contains(s))
                unCommonSet.add(s);
        }

        for (String s: input2Set){
            if (!input1Set.contains(s))
                unCommonSet.add(s);
        }

        unCommonSet.forEach(System.out::println);
        return null;
    }
}
