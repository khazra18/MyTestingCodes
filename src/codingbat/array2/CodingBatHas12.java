package codingbat.array2;

public class CodingBatHas12 {
    public static void main(String[] args) {

        /*Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.


                has12([1, 3, 2]) → true
        has12([3, 1, 2]) → true
        has12([3, 1, 4, 5, 2]) → true*/

        int[] arr = new int[]{3, 2, 4, 5, 1};
        System.out.println(has12(arr));

    }

    static boolean has12(int[] nums) {
        boolean flag = false;
        for (int num : nums) {
            if (num == 1)
                flag = true;
            else if (flag && num == 2)
                return true;
        }
        return false;
    }
}
