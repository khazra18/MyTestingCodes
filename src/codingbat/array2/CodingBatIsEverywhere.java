package codingbat.array2;

public class CodingBatIsEverywhere {
    public static void main(String[] args) {
        /*We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array,
        at least one of the pair is that value. Return true if the given value is everywhere in the array.


        isEverywhere([1, 2, 1, 3], 1) → true
        isEverywhere([1, 2, 1, 3], 2) → false
        isEverywhere([1, 2, 1, 3, 4], 1) → false*/

        int[] arr = new int[]{1, 2, 1, 3, 4 , 5};
        System.out.println(isEverywhere(arr, 2));

    }

    static boolean isEverywhere(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == (nums[i + 1]))
                count++;
        }
        return count == val;
    }
}
