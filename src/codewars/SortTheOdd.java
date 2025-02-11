package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortTheOdd {

    public static void main(String[] args) {

        /*You will be given an array of numbers. You have to sort the odd numbers in ascending order while leaving
        the even numbers at their original positions.

        Examples
                [7, 1]  =>  [1, 7]
        [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
        [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]*/

        Arrays.stream(sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})).forEach(System.out::println);
    }

    static int[] sortArray(int[] array) {

        List<Integer> oddNumberIndexList = new ArrayList<>();
        for (int i = 0 ; i < array.length ;i++){
            if (array[i] % 2 !=0)
                oddNumberIndexList.add(i);
        }
        int[] oddNumberArray = new int[oddNumberIndexList.size()];
        for (int j = 0 ; j < oddNumberIndexList.size() ; j++){
            oddNumberArray[j] = array[oddNumberIndexList.get(j)];
        }
        int[] array1 = Arrays.stream(oddNumberArray).sorted().toArray();
        for (int j = 0 ; j < oddNumberIndexList.size() ; j++){
            array[oddNumberIndexList.get(j)] = array1[j];
        }
        return array;
    }
}
