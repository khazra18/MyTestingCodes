package searchingAndSorting;

public class SelectionSort {

    public static void main(String[] args) {

        int arr[] = new int[]{64,55,11,43,13,9,33,2};
        selectionSortMethod(arr);

    }

    static void selectionSortMethod(int[] param){

        for (int i = 0 ; i < param.length ; i++){

            int min_index = i;
            for (int j = i+1 ; j < param.length ; j++){

                if (param[min_index] > param[j])
                    min_index = j;

            }

            int temp = param[min_index];
            param[min_index] = param[i];
            param[i] = temp;

        }

        for (int i : param) System.out.print(i + " ");

    }

}
