package algorithms.binarySearch;
/*
1) wherever the array or the range is sorted, binary search is applied.
2) The idea is to divide the array in 2 parts, checking in which part the given key lies and eliminating the other part.
 */
public class
BinarySearchImplimentation {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,8,9,10,10,11};
        int key= 0;
        System.out.println(recursiveBinarySearch(arr,0,arr.length-1,12));
        // System.out.println(binarySearch(arr,key));
    }
    // the iterative approach
    public static int binarySearch(int[] arr, int key){
        int low=0;
        int high= arr.length-1;
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    // the recursive approach:
    public static int recursiveBinarySearch(int[] arr, int l, int h, int key){
        int mid= l+(h-l)/2;
        if(l>h){
            return -1;
        }
        else if(arr[mid]==key){
            return mid;
        }
        else if(arr[mid]<key){
            return recursiveBinarySearch(arr,mid+1,h,key);
        }
        else{
            return recursiveBinarySearch(arr,l,mid-1,key);
        }
    }
}
