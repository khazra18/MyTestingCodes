package Test;

import java.util.*;
import java.util.stream.Collectors;

public class Java8CodingExamples {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>(Arrays.asList(2,10,15,9,30,24,56,32,19,60,55,30,32,55));
        System.out.println("Displaying all even numbers - " + findAllEvenFromList(myList));
        System.out.println("Displaying all numbers starting with 1 - " + findAllStartingWithOne(myList));
        System.out.println("Displaying all duplicate numbers from list - " + findDuplicateElements(myList));
        System.out.println("Displaying first element from list - " + findFirstElementFromList(myList));
        System.out.println("Displaying maximum value from list - " + findMaxValFromList(myList));

    }

    //find out all the even numbers exist in the list using Stream functions
    private static List<Integer> findAllEvenFromList(List<Integer> listParam){

        List<Integer> returnList;
        returnList = listParam.stream().filter(integer -> integer%2 == 0).collect(Collectors.toList());
        return returnList;

    }

    //find out all the numbers starting with 1 using Stream functions?
    private static List<Integer> findAllStartingWithOne(List<Integer> listParam){

        List<Integer> returnList;
        returnList = listParam.stream()
                        .map(String::valueOf)
                        .filter(s -> s.startsWith("1"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        return returnList;
    }

    //find duplicate elements in a given integers list
    private static List<Integer> findDuplicateElements(List<Integer> listParam){

        List<Integer> returnList;
        Set<Integer> tempSet = new HashSet<>();
        returnList = listParam.stream().filter(n -> !tempSet.add(n)).collect(Collectors.toList());
        return returnList;
    }

    //find the first element of the list
    private static Integer findFirstElementFromList(List<Integer> listParam){
        Optional<Integer> returnList = listParam.stream().findFirst();
        return returnList.orElse(0);
    }

    //  find the maximum value element present in the list
    private static Integer findMaxValFromList(List<Integer> listParam){
        Optional<Integer> returnList = listParam.stream().sorted(Comparator.reverseOrder()).limit(1).findFirst();
        return returnList.orElse(0);
    }




}
