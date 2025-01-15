package codingbat.array1;

public class CodingBatDouble23 {
    public static void main(String[] args) {
        /*Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.


        double23([2, 2]) → true
        double23([3, 3]) → true
        double23([2, 3]) → false*/

        int[] value = new int[]{1,2,3};
        System.out.println(double23(value));

    }

    static boolean double23(int[] nums) {
        if (nums.length > 1) {

            if (nums[0] == 2 && nums[1] == 2)
                return true;
            else return nums[0] == 3 && nums[1] == 3;

            /*return Arrays.stream(nums).boxed().filter(integer -> integer == 2 || integer == 3)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).containsValue(2L);*/
        }
        return false;
    }
}
