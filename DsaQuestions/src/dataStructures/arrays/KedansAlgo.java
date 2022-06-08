package dataStructures.arrays;
/*
// this problem is also famous as maxSumSubArray.
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
input: {-2,-3,4,-1,-2,1,5,3}.

 */
public class KedansAlgo {
    public static int maxSum(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for (int i = 0; i < arr.length; i++) {
            currSum=currSum+arr[i];
            if(maxSum<currSum){
                maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
}
/*
Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous
subarray sum.


Example 1:

Input:
N = 7
arr[] = {8,-8,9,-9,10,-11,12}
Output:
22
Explanation:
Starting from the last element
of the array, i.e, 12, and
moving in a circular fashion, we
have max subarray as 12, 8, -8, 9,
-9, 10, which gives maximum sum
as 22.

approach: in circular subarray, wrapping is involved, so the ans = toatalSum-(miniSumSubArray).
0r ans= toatalSum-(-MaxSubArraySum : in inverted aerray)

 */
class kedansAlgoInCircularArray{
    public static int maxWithWrap(int[] arr){
        int maxKadane= maxSum(arr);
        if(maxKadane<0){
            return maxKadane;
        }
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            // array invertion to calculate the min sum subarray
            arr[i]=-arr[i];
        }
        //
        sum=sum+maxSum(arr);
        return sum>maxKadane?sum:maxKadane;
    }
    public static int maxSum(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for (int i = 0; i < arr.length; i++) {
            currSum=currSum+arr[i];
            if(maxSum<currSum){
                maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr={-3, -18, -22, -21, -17, 16 ,-14 ,28 ,-22};
        System.out.println(maxWithWrap(arr));
    }
}
