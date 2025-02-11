package array;

import java.util.*;

public class FindIntersectionBetweenTwoGivenArray {

    public static void main(String[] args) {

        int arr1[] = new int[]{2, 4, 6, 8, 9 , 9, 9};
        int arr2[] = new int[]{1, 3, 4, 5, 7, 9};

        //findIntersectionBetweenTwoArray(arr1, arr2);
        findIntersectionBetweenTwoArrayJava8(arr1, arr2);

    }

    static void findIntersectionBetweenTwoArray(int[] arr1, int[] arr2) {

        List<Integer> myList = new ArrayList<>();
        for (int k : arr1) {
            for (int i : arr2) {
                if (k == i) {
                    myList.add(k);
                    break;
                }
            }
        }
        myList.forEach(System.out::println);
    }

    static void findIntersectionBetweenTwoArrayJava8(int[] arr1, int[] arr2) {

        Arrays.stream(arr1).filter(value -> Arrays.stream(arr2).anyMatch(value1 -> value1==value)).distinct().forEach(System.out::println);

    }

}
