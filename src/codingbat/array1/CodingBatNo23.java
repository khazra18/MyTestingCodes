package codingbat.array1;

public class CodingBatNo23 {
    public static void main(String[] args) {
        /*Given an int array length 2, return true if it does not contain a 2 or 3.


        no23([4, 5]) → true
        no23([4, 2]) → false
        no23([3, 5]) → false*/

        int[] arr = new int[]{5,6,7,8,9,3};
        System.out.println(no23(arr));
    }
    static boolean no23(int[] nums){
        for (int num : nums) {
            if (num == 2 || num == 3)
                return false;
        }
        return true;
    }
}
