package algorithms.twoPointerApproach;

import java.util.Arrays;

/*
Given an array Arr[] of N distinct integers and a range from L to R, the task is to count the number of triplets
having a sum in the range [L, R].


Example 1:

Input:
N = 4
Arr = {8 , 3, 5, 2}
L = 7, R = 11
Output: 1
Explaination: There is only one triplet {2, 3, 5}
having sum 10 in range [7, 11].
 */
public class TripletsInGivenRange {
    public static void main(String[] args) {

    }
    public static int countTriplets(int[] arr, int n, int l, int r){
      int res;
      res=countLessThanEqualTo(arr,n,r)-countLessThanEqualTo(arr,n,l-1);
      return res;
    }
    public static int countLessThanEqualTo(int[] arr, int n, int val){
        int i=0,count=0;
        Arrays.sort(arr);
        while (i< n-2){
            int j=i+1,k=n-1;
            while (j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum>val){
                    k--;
                }
                else {
                    count+=(k-j);
                    j++;
                }
            }
            i++;
        }
        return count;
    }
}
