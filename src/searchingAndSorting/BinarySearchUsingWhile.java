package searchingAndSorting;

public class BinarySearchUsingWhile {

    public static void main(String[] args) {

        int[] arr = new int[]{10,20,30,40,50,60,70,80,90,100,110,120};
        binarySearchAlgo(arr,120);
    }

    static void binarySearchAlgo(int arr[], int element) {

        int low = 0;
        int high = arr.length - 1;

        while (high - low > 1) {

            int mid = (high + low) / 2;
            if (arr[mid] == element) {
                System.out.println("Element : " + element + " found at index : " + mid);
                return;
            } else if (element > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (arr[low] == element) {
            System.out.println("Element : " + element + " found at index : " + low);
        } else if (arr[high] == element) {
            System.out.println("Element : " + element + " found at index : " + high);
        } else {
            System.out.println("Element not found");
        }

    }

}
