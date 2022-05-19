package algorithms.binarySearch;
/*
Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
 */
public class SearchIninfiniteSortedArray {
    public static void main(String[] args) {

    int[] arr={1,2,3,3,4,4,4,4,4,5,6,6,6,8,8,8,8,8,8,8,9,9,9,9,9,19};
        System.out.println(searchInInfiniteArray(arr,5));
    }
    public static int searchInInfiniteArray(int[] arr,int key){
        int lo=arr[0];
        int hi=arr[1];
        while (arr[hi]<key){
            lo=hi;
            hi=hi*2;
        }
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }

        }
        return -1;
    }
}
