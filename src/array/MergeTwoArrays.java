package array;

import java.util.Arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {

        /*Given two arrays of integers, merge them into a single sorted array in order.

        Example:
        Array1: [1,2,3,4,5]
        Array2: [2,3,6,7,8]

        Output:

        Array = [1,2,2,3,3,4,5,6,7,8]*/

        int[] arrayOne = new int[]{1,3,5,7,9};
        int[] arrayTwo = new int[]{2,4,6,8,10};

        merge(arrayOne,arrayTwo);
    }

    static void merge(int[] arrayOne,int[] arrayTwo){

        int totalLength = arrayOne.length + arrayTwo.length;
        int[] sortedArray = new int[totalLength];
        int i = 0,j = 0,index = 0;

        while ((i != arrayOne.length) && (j!= arrayTwo.length)){

            if (arrayOne[i] < arrayTwo[j]){
                sortedArray[index] = arrayOne[i];
                index++;
                i++;
            }else if (arrayOne[i] > arrayTwo[j]){
                sortedArray[index] = arrayTwo[j];
                index++;
                j++;
            }else {
                sortedArray[index] = arrayOne[i];
                index++;
                sortedArray[index] = arrayTwo[j];
                index++;
                i++;
                j++;
            }
            if (i == arrayOne.length){
                while (j!= arrayTwo.length){
                    sortedArray[index] = arrayTwo[j];
                    index++;
                    j++;
                }
            }
            if (j == arrayTwo.length){
                while (i!= arrayOne.length){
                    sortedArray[index] = arrayOne[i];
                    index++;
                    i++;
                }
            }

        }
        Arrays.stream(sortedArray).forEach(System.out::println);

    }


}
