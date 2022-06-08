package algorithms.binarySearch;
/*
you are given an array that is biotonic, search the given kry element in that series. if the array is increasing are decreasing then
print invalid input, if the key element is present the print the index, if it's not found then print "not found"
 */
public class SearchInBiotonicSequence {
    public static void main(String[] args) {
       int[] arr={1,2,3,6,5,4,3,0};
       searchInBiotonic(arr,9);
    }
    public static void searchInBiotonic(int[] arr,int key){
        if(biotonicPoint(arr)!=-1){
            int idx=biotonicPoint(arr);
            int res1=binarySearch(arr,0,idx,key);
            // for res2, search in binary for the decresing one, so create another function to search
            int res2= binarySearchDecreasing(arr,idx+1,arr.length-1,key);
            if(res1>-1 && res2>-1){
                System.out.println("indecies are"+res1+" and "+res2);
            }
            else if(res1>-1){
                System.out.println("index is "+res1);
            }
            else if(res2>-1){
                System.out.println("index is "+res2);
            }
            else {
                System.out.println("Not present");
            }
        }
        else {
            System.out.println("invalid input");
        }
    }
    public static int biotonicPoint(int[] arr){
        int lo=1,mid=0;
        int n=arr.length;
        int hi= arr.length-2;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid-1]<arr[mid]){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr,int lo,int hi, int key){
        int low=lo;
        int high= hi;
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
    public static int binarySearchDecreasing(int[] arr,int lo,int hi, int key){
        int low=lo;
        int high= hi;
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
