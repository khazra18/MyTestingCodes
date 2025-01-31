package codingbat.array2;

public class CodingBatEither24 {
    public static void main(String[] args) {
        /*Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.


        either24([1, 2, 2]) → true
        either24([4, 4, 1]) → true
        either24([4, 4, 1, 2, 2]) → false*/

        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(either24(arr));
    }

    static boolean either24(int[] nums) {

        boolean flag1 = false;
        boolean flag2 = false;

        for (int i = 0 ; i < nums.length-1 ; i++){
            if (nums[i] == 2 && nums[i+1] == 2){
                flag1 = true;
            }else if (nums[i] == 4 && nums[i+1] == 4){
                flag2 = true;
            }
        }
        if (flag1 && flag2){
            return  false;
        }else {
            return flag1||flag2;
        }
    }

}
