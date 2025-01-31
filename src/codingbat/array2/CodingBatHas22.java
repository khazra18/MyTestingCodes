package codingbat.array2;

public class CodingBatHas22 {
    public static void main(String[] args) {

        /*Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.


                has22([1, 2, 2]) → true
        has22([1, 2, 1, 2]) → false
        has22([2, 1, 2]) → false*/

        int[] arr = new int[]{1, 1, 1, 2};
        System.out.println(has22(arr));

    }

    static boolean has22(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2 && (i + 1) < nums.length && nums[i + 1] == 2)
                return true;
        }
        return false;
    }
}
