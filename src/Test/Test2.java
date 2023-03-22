package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        String str = "krishanu hazra is a bad boy";

        String[] strsplit = str.trim().split("");

        for (String s: strsplit) {
            System.out.print(s);
        }

        ArrayList<String> listStr = new ArrayList<>(Arrays.asList(strsplit));

        System.out.println("List : " + listStr);

        Map<String,Long> myMap = listStr.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(myMap);

        myMap.forEach((k,v) -> {
            if (v > 1){
                System.out.println(k + " - " + v);
            }
        });

    }

}
