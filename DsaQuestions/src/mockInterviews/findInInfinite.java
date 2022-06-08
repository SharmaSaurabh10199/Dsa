package mockInterviews;

import java.util.Hashtable;

public class findInInfinite {
    public static int findTarget(int[] arr, int target){
        //Hashtable<Integer,Integer> ht
        // 0.....n/2....n

        int low=0;

        int high= 1;
        while (arr[high]<target){
            int temp= high+1;
            //low=high+1;
            int size=high-low+1;
            high=high+size*2;
            low=temp;
        }
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }

}
