package codingbat.array1;

public class CodingBatHas23 {
    public static void main(String[] args) {
        /*Given an int array length 2, return true if it contains a 2 or a 3.


        has23([2, 5]) → true
        has23([4, 3]) → true
        has23([4, 5]) → false*/

        int[] arr = new int[]{5,6,7,8,9,3};
        System.out.println(has23(arr));

    }

    static boolean has23(int[] nums){
        for (int num : nums) {
            if (num == 2 || num == 3)
                return true;
        }
        return false;
    }
}
