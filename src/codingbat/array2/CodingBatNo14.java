package codingbat.array2;

import java.util.Arrays;

public class CodingBatNo14 {
    public static void main(String[] args) {
        /*Given an array of ints, return true if it contains no 1's or it contains no 4's.


                no14([1, 2, 3]) → true
        no14([1, 2, 3, 4]) → false
        no14([2, 3, 4]) → true*/
        int[] arr = new int[]{1, 2, 3,1,4,1};
        System.out.println(no14(arr));

    }

    static boolean no14(int[] nums) {
        boolean flag1 = false;
        boolean flag4=false;

        for (int num: nums){
            if (num == 4)
                flag4 = true;
            else if (num ==1 )
                flag1 = true;
        }
        return !flag1 || !flag4;
    }

}
