package arraycodingpractice;

import java.util.Arrays;

public class SortZeroAndOne {

    public static void main(String[] args) {

        int[] arr = new int[]{0,1,1,0,0,0,1,1,1,0};
        sortArray(arr);

    }

    static void sortArray(int[] param){

        //we need to sort the array like 0,0,0,0,0,1,1,1,1,1

        int[] sortedArr = Arrays.stream(param)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        int[] zerosAndOnes = Arrays.stream(sortedArr)
                .filter(num -> num == 0 || num == 1)
                .toArray();

        System.out.println(Arrays.toString(zerosAndOnes));

    }


}
