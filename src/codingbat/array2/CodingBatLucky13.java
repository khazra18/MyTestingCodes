package codingbat.array2;

public class CodingBatLucky13 {
    public static void main(String[] args) {

        /*Given an array of ints, return true if the array contains no 1's and no 3's.


        lucky13([0, 2, 4]) → true
        lucky13([1, 2, 3]) → false
        lucky13([1, 2, 4]) → false*/

        int[] arr = new int[]{1, 2, 4};
        System.out.println(lucky13(arr));

    }

    static boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) {
                return false;
            }
        }
        return true;
    }

}
