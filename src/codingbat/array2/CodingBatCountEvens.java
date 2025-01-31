package codingbat.array2;

public class CodingBatCountEvens {
    public static void main(String[] args) {


        /*Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.


        countEvens([2, 1, 2, 3, 4]) → 3
        countEvens([2, 2, 0]) → 3
        countEvens([1, 3, 5]) → 0*/

        int[] arr = new int[]{1, 1, 3};
        System.out.println(countEvens(arr));

    }

    static int countEvens(int[] nums) {
        int count = 0;
        for (int i: nums){
            if (i%2 == 0)
                count++;
        }
        return count;
    }

}
