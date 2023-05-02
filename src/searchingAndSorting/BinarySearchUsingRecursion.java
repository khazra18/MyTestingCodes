package searchingAndSorting;

public class BinarySearchUsingRecursion {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
        System.out.println("element is present at index " + binarySearch(arr, 110, 0, arr.length - 1));
    }

    static int binarySearch(int arr[], int element, int low, int high) {

        if (high >= low) {

            int mid = (high + low) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (element > arr[mid]) {
                return binarySearch(arr, element, mid + 1, high);
            } else {
                return binarySearch(arr, element, low, mid - 1);
            }
        }
        return -1;
    }

}
