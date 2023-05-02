package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepetitiveCharInAString {

    public static void main(String[] args) {

        //FindFirstNonRepetitiveCharInAString using java 8 stream api
        System.out.println(getFirstNonRepetitiveCharInAString("AaBbcCfgg"));

        //getFirstNonRepetitiveCharInAStringNotUsingJava8
        System.out.println(getFirstNonRepetitiveCharInAStringNotUsingJava8("Tirthankar das"));

    }

    private static String getFirstNonRepetitiveCharInAString(String myString) {

        String temp = myString.replaceAll("\\s","").toLowerCase();
        System.out.println(temp);
        List<String> myList = new ArrayList<>(Arrays.asList(temp.split("")));

        LinkedHashMap<String,Long> myMap = myList.stream()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        System.out.println(myMap);

        for (Map.Entry<String, Long> temp1 : myMap.entrySet()) {
            if (temp1.getValue() == 1)
                return temp1.getKey();
        }

        return "There is no non repetitive character";
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
