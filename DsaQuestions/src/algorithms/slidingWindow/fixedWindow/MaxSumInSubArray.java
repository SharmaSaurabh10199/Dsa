package algorithms.slidingWindow.fixedWindow;

import java.util.ArrayList;

/*
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.



Example 1:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.
 */
public class MaxSumInSubArray {
    static int maxSumInSubArrayOfSizek(ArrayList<Integer> Arr, int k){
        int i=0,j=0,sum=0,maxSum=Integer.MIN_VALUE;
        while (j< Arr.size()){
            sum+=Arr.get(j);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                maxSum=Math.max(sum,maxSum);
                sum-=Arr.get(i);
                i++;
                j++;
            }
        }
        return maxSum;

    }
}
