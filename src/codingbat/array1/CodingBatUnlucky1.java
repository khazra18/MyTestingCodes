package codingbat.array1;

public class CodingBatUnlucky1 {
    public static void main(String[] args) {

        /*We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1.
        Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array.


        unlucky1([1, 3, 4, 5]) → true
        unlucky1([2, 1, 3, 4, 5]) → true
        unlucky1([1, 1, 1]) → false*/

        int[] arr = new int[]{2, 3, 1, 3, 2, 1, 3};
        System.out.println(unlucky1(arr));
    }

    static boolean unlucky1(int[] nums) {
        if (nums.length < 2) return false; // If the array has fewer than 2 elements, no unlucky 1 is possible.

        // Check first two positions and last two positions for an "unlucky" 1.
        return nums[0] == 1 && nums[1] == 3 || nums[1] == 1 && nums[2] == 3 || nums[nums.length - 2] == 1 && nums[nums.length - 1] == 3;
    }
}
