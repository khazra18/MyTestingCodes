package codingbat.array2;

public class CodingBatOnly14 {
    public static void main(String[] args) {
        /*Given an array of ints, return true if every element is a 1 or a 4.


        only14([1, 4, 1, 4]) → true
        only14([1, 4, 2, 4]) → false
        only14([1, 1]) → true*/

        int[] arr = new int[]{1, 4, 1, 4,1};
        System.out.println(only14(arr));
    }

    static boolean only14(int[] nums) {

        for (int num : nums){
            if (num != 1 && num != 4) {
                return false;
            }

        }
        return true;
    }
}
