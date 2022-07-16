package algorithms.binarySearch;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
public class SearchInRotatedSorted {
    public static void main(String[] args) {
        int[] arr={5,6,7,8,9,10,1,2,3};

        System.out.println(findInSortedRotated(arr,10));
        System.out.println(findPivot(arr,arr.length-1));
    }
    public static int findInSortedRotated(int[] arr, int key){
        int idx= findPivot(arr,arr.length);
        if(idx==arr.length-1){
            return binarySearch(arr,0,arr.length-1,key);
        }
        int res1= binarySearch(arr,0,idx,key);
        int res2=binarySearch(arr,idx+1,arr.length-1,key);
        if(res1<0 && res2<0){
            return -1;
        }
        else if(res1>=0){
            return res1;
        }
        return res2;

    }
    public static int findPivot(int[] arr, int n){
        if(arr[0]<arr[n-1]){
            return n-1;
        }
        int lo=0;
        int hi=arr.length-1;
        int mid=lo+(hi-lo)/2;
        while (lo<=hi){
             mid= lo+(hi-lo)/2;
            int next= (mid+1)%n;
            int prev=(mid+n-1)%n;
            if(arr[mid]>arr[next] && arr[mid]>=arr[prev]){
                break;
            }
            else if(arr[mid]<=arr[lo]){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return mid;
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

}
