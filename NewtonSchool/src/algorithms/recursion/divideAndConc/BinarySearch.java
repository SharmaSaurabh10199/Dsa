package algorithms.recursion.divideAndConc;

public class BinarySearch {
    public static int binarySearch(int[] arr, int low, int hi, int key){
        if(low>hi){
            return -1;
        }
        int mid=low+(hi-low)/2;
        if(arr[mid]==key){
            return mid;
        }
        if(arr[mid]<key){
            return binarySearch(arr,mid+1,hi,key);
        }
        return binarySearch(arr,low,mid-1,key);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,};
        System.out.println(binarySearch(arr,0,arr.length-1,52));
    }
}
