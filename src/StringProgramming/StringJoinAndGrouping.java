package StringProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinAndGrouping {

    public static void main(String[] args) {

        List<String> groupOfString = new ArrayList<>(Arrays.asList("Pear","Guava","Apple","Papaya"));
        List<String> joinString = new ArrayList<>(Arrays.asList("Pear","Guava","Apple","Papaya"));

        //Group a list of string with their length
        groupAListOfString(groupOfString);

        //join a list of string
        joinString(joinString);

    }

    static void groupAListOfString(List<String> param){

        param.stream().collect(Collectors.groupingBy(String::length)).entrySet().forEach(System.out::println);

    }

    static void joinString(List<String> param){
        System.out.println(param.stream().collect(Collectors.joining("-","(",")")));
    }

}
