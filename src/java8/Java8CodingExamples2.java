package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8CodingExamples2 {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(4,6,10,7,2,15,14,9);
        System.out.println("Sum of all integers present in list : " + sumOfMyList(myList));

        //Predicate example
        Predicate<Integer> checkIfPresent = integer -> integer == 6;
        System.out.println("Predicate value for all list : " + checkIfPresentInMyList(myList,checkIfPresent));

        //Function interface
        Function<Integer,Integer> multiPlyFunction = integer -> integer * 2;
        System.out.println("Function value for all list : " + multiPlyFunctionInMyList(myList,multiPlyFunction));

    }

    private static Integer sumOfMyList(List<Integer> myList) {
        return myList.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> checkIfPresentInMyList(List<Integer> myList,Predicate<Integer> myCheck){
        return myList.stream().filter(myCheck).collect(Collectors.toList());
    }

    private static List<Integer> multiPlyFunctionInMyList(List<Integer> myList,Function<Integer,Integer> myFunc){
        return myList.stream().map(myFunc).collect(Collectors.toList());
    }


}
