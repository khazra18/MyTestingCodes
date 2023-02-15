package Test;

import java.util.*;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        List<Integer> myList = Arrays.asList(3,5,2,7,6,10,8,14);
        List<Integer> myDemoList = new ArrayList<>();

        myList.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).forEach(System.out::println);
        myList.stream().sorted().limit(1).forEach(System.out::println);

    }

}

