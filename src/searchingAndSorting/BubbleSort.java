package searchingAndSorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{11,64,5,55,12,43,13,9,33,2};
        bubbleSortMethod(arr);

    }

    static void bubbleSortMethod(int[] arr){

        for (int i = 0 ; i < arr.length-1 ; i++){

            for (int j = 0 ; j < arr.length-i-1 ; j++){

                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }

        for (int i : arr) System.out.print(i + " ");
    }

}
