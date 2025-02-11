package array;

public class MinimumDistanceBetweenElements {
    public static void main(String[] args) {
        /*Given an array of n elements, and two integers say x and y, present in the array, find out the minimum distance between
        x and y in the array, that is the number of elements between x and y, including y. If the elements are not present print infinite value.

                Example:
        ArrayOne = [1, 2, 3, 4, 5, 6]
        x = 2
        y = 5
        Output
        3*

        Check for the first occurrence of x or y in the array and store that index in a variable say z. Now continue traversing the array, if you find x or y,
        and it is not equal to the element at z, then update the minimum distance. Finally, update the index in variable z.

         */

        int[] arr = new int[]{1, 2, 3, 4, 5, 6 , 7 , 8};
        System.out.println(minDistance(arr,8,1));

    }

    static int minDistance(int[] arr, int x , int y){
        int firstPos = 0;
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == x || arr[i] == y){
                firstPos = i;
                break;
            }
        }

        for (int j = firstPos +1 ; j < arr.length ; j++){
            if (arr[j] == x || arr[j] == y){
                firstPos = j - firstPos;
                break;
            }
        }
        return firstPos;
    }
}
