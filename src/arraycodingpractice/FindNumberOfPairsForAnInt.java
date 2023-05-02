package arraycodingpractice;

public class FindNumberOfPairsForAnInt {

    public static void main(String[] args) {

        //Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
        int arr[] = new int[]{1, 1 , 1,1,1};
        System.out.println(getPairsCount(arr,5,2));

    }

    static int getPairsCount(int[] arr, int n, int k) {

        int mPairsCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp1 = arr[i];
                int temp2 = arr[j];
                if (temp1 + temp2 == k)
                    mPairsCount++;
            }
        }
        return mPairsCount;
    }

}
