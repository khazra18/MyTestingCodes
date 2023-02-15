package java8;

import java.util.StringJoiner;

public class StringJoinerExample {

    public static void main(String[] args) {

        //Java 8 Program to add prefix and suffix to the String
        System.out.println(methodForAddPrefixAndSuffix());



    }

    private static String methodForAddPrefixAndSuffix(){

        StringJoiner joiner1 = new StringJoiner(",","(",")");
        joiner1.add("Krishanu");
        joiner1.add("Krishanu1");
        joiner1.add("Krishanu2");
        joiner1.add("Krishanu3");

        return String.valueOf(joiner1);
    }

}
