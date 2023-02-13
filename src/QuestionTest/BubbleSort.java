package QuestionTest;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] myArr = {10,5,7,2,9};
        System.out.println(Arrays.toString(getBubbleSort(myArr)));

    }

    static int[] getBubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

}
