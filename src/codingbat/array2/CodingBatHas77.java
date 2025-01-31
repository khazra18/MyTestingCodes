package codingbat.array2;

public class CodingBatHas77 {
    public static void main(String[] args) {
        /*Given an array of ints, return true if the array contains two 7's next to each other, or there are two 7's
        separated by one element, such as with {7, 1, 7}.


        has77([1, 7, 7]) → true
        has77([1, 7, 1, 7]) → true
        has77([1, 7, 1, 1, 7]) → false*/

        int[] arr = new int[]{2, 7, 2, 2, 7, 2};
        System.out.println(has77(arr));
    }

    static boolean has77(int[] nums) {
        for (int i = 0 ; i < nums.length -1 ; i++){
            if (nums[i] == 7 && nums[i+1] ==7)
                return true;
            else if (nums[i] == 7 && i < nums.length - 2 && nums[i+2] == 7)
                return true;
        }
        return false;
    }

}
