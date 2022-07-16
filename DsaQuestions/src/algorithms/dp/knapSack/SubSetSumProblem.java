package algorithms.dp.knapSack;
/*
Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.


Example 1:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.
 */
public class SubSetSumProblem {
    // memoization

    // here problem in memoization becase the default values of matrix and result are overlapping
    static boolean solve(int n, int sum, int[] arr,int[][] dp){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]>sum){
            return solve(n-1,sum,arr,dp);
        }
        else{
            return solve(n-1,sum-arr[n-1],arr,dp) || solve(n-1,sum,arr,dp);
        }
    }
    // tabulation approach
    static boolean solveByTabulation(int n , int sum, int[] arr){
        boolean[][] t= new boolean[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            t[i][0]= true;
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                else {
                    t[i][j]=t[i-1][j] || t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][sum];
    }
}
