package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;

/*
Given an array Arr[] of N distinct integers and a range from L to R, the task is to count the number of triplets having a sum in the range [L, R].


Example 1:

Input:
N = 4
Arr = {8 , 3, 5, 2}
L = 7, R = 11
Output: 1
Explaination: There is only one triplet {2, 3, 5}
having sum 10 in range [7, 11].
 */
public class TripletsWithGivenSumRange {
    public static void main(String[] args) {
    int[] arr={5, 1, 4, 3, 2};
        System.out.println(countTriplets(arr,arr.length,2,7));
    }
    // non optimized approach:
    public static int countTriplets(int[] arr, int n ,int l, int r){
        Arrays.sort(arr);
        int count=0;
        for (int i = 0; i <n-2 ; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum=arr[i]+arr[j]+arr[k];
                    if(sum>=l && sum<=r){
                        count++;
                    }
                    else if(sum>r){
                        break;
                    }
                }
            }
        }
        return count;
    }
}
