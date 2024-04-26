package searchingAndSorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 7, 3, 1, 10, 18, 16, 14, 12};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void quickSort(Integer[] arr, int low, int high) {

        if (low < high) {

            int pivot = getPivotIndex(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);

        }

    }

    private static int getPivotIndex(Integer[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (arr[i] <= pivot && i <= high - 1)
                i++;

            while (arr[j] > pivot && j >= low + 1)
                j--;

            if (i < j)
                swapMethod(arr, i, j);
        }

        swapMethod(arr, low, j);
        return j;
    }

    private static void swapMethod(Integer[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
