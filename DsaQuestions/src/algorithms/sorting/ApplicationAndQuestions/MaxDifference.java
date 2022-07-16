package algorithms.sorting.ApplicationAndQuestions;
/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the
constraint of A[i] < A[j] and i < j.

Example 2:

Input:
N = 9
A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array A[1] < A[7]
satisfying the required
condition(A[i] < A[j]) thus giving
the maximum difference of j - i
which is 6(7-1).
 */
public class MaxDifference {
    public static void main(String[] args) {
        int arr[]= {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxDiff(arr,arr.length));
    }
    static int maxDiff(int[] arr, int n){
        int i=0,j=n-1,max=-1;
        while (i<n-1){
            if(arr[i]<=arr[j]){
                int length=j-i;
                max=Math.max(max,length);
                i++;
                j=n-1;
            }
            else {
                j--;
            }
        }
        return max;
    }
}
