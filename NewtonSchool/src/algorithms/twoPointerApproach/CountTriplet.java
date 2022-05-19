package algorithms.twoPointerApproach;

import java.util.Arrays;

/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets:
1 + 2 = 3 and 3 +2 = 5
You don't need to read input or print anything. Your task is to complete the function countTriplet()
which takes the array arr[] and N as inputs and returns the triplet count
 */
public class CountTriplet {
    public static void main(String[] args) {

        int arr[] = {1, 5, 3, 2};
        System.out.println(countTriplets(arr));
    }
    public static int countTriplets(int[] arr){
        Arrays.sort(arr);
        int count=0;
        int r= arr.length-1;
        while (r>1){
            int i=0;
            int k=r-1;
            while (i<k){
                if(arr[i]+arr[k]==arr[r]){
                    count++;
                    i++;k--;
                }
                else if(arr[i]+arr[k]<arr[r]){
                    i++;
                }
                else {
                    k--;
                }
            }
            r--;
        }
        return count;
    }
}
