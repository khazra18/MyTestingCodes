package java8;

import java.util.*;

public class FindFirstNonRepetitiveCharInAString {

    public static void main(String[] args) {

        //FindFirstNonRepetitiveCharInAString using java 8 stream api
        System.out.println(getFirstNonRepetitiveCharInAString("Krishanu hazra"));

        //getFirstNonRepetitiveCharInAStringNotUsingJava8
        System.out.println(getFirstNonRepetitiveCharInAStringNotUsingJava8("Tirthankar das"));

    }

    private static char getFirstNonRepetitiveCharInAString(String myString) {

        List<String> myList = new ArrayList<>(Arrays.asList(myString.split("")));
        System.out.println(myList);

        return 'A';
    }

    private static String getFirstNonRepetitiveCharInAStringNotUsingJava8(String myString) {

        List<String> myList = new ArrayList<>(Arrays.asList(myString.split("")));
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<>();

        for (String s : myList) {
            String temp = s.toLowerCase();
            if (myMap.isEmpty()) {
                myMap.put(temp, 1);
            } else {
                if (myMap.containsKey(temp)) {
                    int val = myMap.get(temp);
                    val = val + 1;
                    myMap.put(temp, val);
                } else {
                    myMap.put(temp, 1);
                }
            }
        }

        System.out.println(myMap);
        for (Map.Entry<String, Integer> tempMap : myMap.entrySet()) {
            if (tempMap.getValue() == 1) return tempMap.getKey();
        }
        return "null";
    }

}
