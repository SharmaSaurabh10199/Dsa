package algorithms.binarySearch;
/*
Given an array sorted in descending order, you have to search an element in that array;
 */
public class SearchInDescendingSorted {
    public static void main(String[] args) {
        int[] arr={6,5,4,3,2,0};
        System.out.println(binarySearchInDescendingSorted(arr,0));
    }
    public static int binarySearchInDescendingSorted(int[] arr, int key){
        int low=0;
        int high= arr.length-1;
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
