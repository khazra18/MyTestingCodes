package codingbat.array1;

public class SumOfArray {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};
        System.out.println(sumofArray(arr));
    }

    public static int sumofArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}
