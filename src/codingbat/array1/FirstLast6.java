package codingbat.array1;

public class FirstLast6 {
    public static void main(String[] args) {
    /*
        Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
        firstLast6([1, 2, 6]) → true
        firstLast6([6, 1, 2, 3]) → true
        firstLast6([13, 6, 1, 2, 3]) → false
    */

        int[] arr = {9, 6, 1, 2, 3, 4, 5};
        System.out.println(firstOrLast6(arr));
    }

    public static boolean firstOrLast6(int[] arr){
        return arr[0] == 6 || arr[arr.length - 1] == 6;
    }
}
