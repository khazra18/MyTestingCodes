package leetcode;

import java.util.Arrays;
import java.util.List;

public class TwoSumQ1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoSumIndicesReturn(new int[]{2,5,5,11}, 10)));
    }

    public static int[] getTwoSumIndicesReturn(int[] nums, int target) {

        int[] returnArray = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {
                int tempi = nums[i];
                int tempj = nums[j];

                if (tempi+tempj == target){

                    returnArray[0] = i;
                    returnArray[1] = j;
                    return returnArray;

                }

            }
        }
        return null;
    }

}
