package codingbat.array1;

public class CodingBatStart1 {
    public static void main(String[] args) {

        /*Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.


        start1([1, 2, 3], [1, 3]) → 2
        start1([7, 2, 3], [1]) → 1
        start1([1, 2], []) → 1*/

        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{};
        System.out.println(start1(arr1,arr2));

    }

    static int start1(int[] a,int[] b){
        int count = 0;
        if (a.length > 0 && a[0]==1){
             count++;
        }
        if (b.length>0 && b[0] == 1){
            count++;
        }
        return count;
    }
}
