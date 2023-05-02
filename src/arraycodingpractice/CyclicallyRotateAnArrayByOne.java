package arraycodingpractice;

import java.util.Arrays;

public class CyclicallyRotateAnArrayByOne {

    public static void main(String[] args) {

        //Cyclically rotate an array by one
        int arr[] = new int[]{1,2,3,4,5};
        rotate(arr,5);

    }

    public static void rotate(int arr[],int n){

        int[] arr1 = new int[n];
        arr1[0] = arr[arr.length-1];
        for (int i = 0 ; i < arr.length-1 ; i++){
            arr1[i+1] = arr[i];
        }

        System.out.println(Arrays.toString(arr1));

    }

}
