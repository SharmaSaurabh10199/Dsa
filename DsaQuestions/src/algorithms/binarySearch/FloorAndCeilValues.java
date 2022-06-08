package algorithms.binarySearch;
/*
you are given a sorted array, you have to find the floor and ceil values of given key
 */
public class
FloorAndCeilValues {
    public static void main(String[] args) {
        int[] arr={1,2,4,6,8,9};
        floorAndCeil(arr,10);
    }
    public static void floorAndCeil(int[] arr, int key) {
        if (key < arr[0] || key > arr[arr.length - 1]) {
            System.out.println("out of range");
        } else {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == key) {
                    System.out.println(mid);
                    return;
                } else if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println("floor value is " + arr[high]);
            System.out.println("ceil value is " + arr[low]);
        }
    }
}
