package codingbat.array1;

import java.util.Arrays;

public class CodingBatMiddleWay {
    public static void main(String[] args) {


        /*Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements.

        middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
        middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
        middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]*/

        int[] a = new int[]{1,2,3,4,5,6,7};
        int[] b = new int[]{10,11,12,13,14,15,16};

        int[] middleway = middleway(a, b);
        Arrays.stream(middleway).forEach(System.out::println);

    }

    static int[] middleway(int[] a,int[] b){

        int[] midarray = new int[2];

        int midpointera = (int) Math.ceil((double) a.length /2)-1;
        int midpointerb = (int) Math.ceil((double) b.length /2)-1;

        midarray[0] = a[midpointera];
        midarray[1] = b[midpointerb];

        return midarray;
    }
}
