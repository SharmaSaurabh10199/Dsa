package algorithms.binarySearch;
/*
You are given a bitonic sequence, the task is to find Bitonic Point in it. A Bitonic Sequence is a sequence
of numbers which is first strictly increasing then after a point strictly decreasing.

A Bitonic Point is a point in bitonic sequence before which elements are strictly increasing and
after which elements are strictly decreasing. A Bitonic point doesn’t exist if array is only decreasing or only increasing.

Examples :


Input : arr[] = {6, 7, 8, 11, 9, 5, 2, 1}
Output: 11
All elements before 11 are smaller and all
elements after 11 are greater.

Input : arr[] = {-3, -2, 4, 6, 10, 8, 7, 1}
Output: 10
 */
public class MaxInBiotonuicSequence {
    public static void main(String[] args) {
   int[] arr={1,2,4};
        System.out.println(biotonicPoint(arr));
    }
    public static int biotonicPoint(int[] arr){
        int lo=1,mid=0;
        int n=arr.length;
        int hi= arr.length-2;
        while (lo<=hi){
             mid=lo+(hi-lo)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return arr[mid];
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
}
