package codingbat.array1;

import java.util.Arrays;

public class CodingBatFix23 {
    public static void main(String[] args) {

        /*Given an int array length 3, if there is a 2 in the array immediately followed by a 3, set the 3 element to 0. Return the changed array.


        fix23([1, 2, 3]) → [1, 2, 0]
        fix23([2, 3, 5]) → [2, 0, 5]
        fix23([1, 2, 1]) → [1, 2, 1]*/

        int[] arr = new int[]{2,3,1,4,5,6};
        Arrays.stream(fix23(arr)).forEach(System.out::println);

    }

    static int[] fix23(int[] nums) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2 && i < nums.length - 1) {
                if (nums[i + 1] == 3) {
                    index = i + 1;
                    flag = true;
                    break;
                }
            }
        }
        if (flag){
            nums[index] = 0;
        }
        return nums;
    }
}
