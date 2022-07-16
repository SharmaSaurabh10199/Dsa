package rough;

public class DsaEasy {
    /*
    Write a function that takes in a sorted array and a target element and returns true if the target element is present in the array.
     */

    /*
    Write a function that takes in a sorted array of integers and a target integer. The function should return a range of indices in between
    which the target number is contained. The first number in the o/p is the first index at which the number is located and the second number
    is the last index at which the given target number is located. Return [-1, -1] if the number is not found.

Sample i/p: arr = [0, 1, 1, 8, 10, 10, 15, 15, 15, 78, 94, 98] target = 15 Sample o/p: [6, 8]
     */
    public static void main(String[] args) {
        int[] arr={0, 1, 1, 8, 10, 10, 15, 15, 15, 78, 94, 98};
        System.out.println(findMinIndex(arr,15)+" "+finMaxIndex(arr,15));

    }


    static boolean hasKey(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        return false;
    }

    static int findMinIndex(int[] arr, int key) {
        int lo = 0;
        int res = -1;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                res = mid;
                hi = mid - 1;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        return res;
    }

    static int finMaxIndex(int[] arr, int key){
        int lo = 0;
        int res = -1;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                res = mid;
//                hi = mid - 1;
                lo=mid+1;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;

    }

}

