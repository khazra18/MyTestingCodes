package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Java8CodingExamples3 {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(2,10,15,9,30,24,56,32,19,60,55,30,32,55));

        //Function functional interface example
        Function<List<Integer>,Integer> myFunction = integers -> integers.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(myFunction.apply(myList));
    }
}
