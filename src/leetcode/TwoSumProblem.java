package leetcode;

import java.util.HashMap;

public class TwoSumProblem {

    public static void main(String[] args) {

        int[] arr = {2,3,10,8,6};
        int output = 16;

        two(arr,output);

    }

    static void two(int[] arr, int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr.length ; i++){
            int tempVal = target - arr[i];
            if (map.containsKey(tempVal)){
                System.out.println(arr[i] + " - " + tempVal);
                return;
            }
            map.put(arr[i],i);
        }
        System.out.println("No match found");
    }

}
