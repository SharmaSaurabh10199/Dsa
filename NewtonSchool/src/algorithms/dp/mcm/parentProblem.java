package algorithms.dp.mcm;
/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves
the least number of multiplications.
The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has
the dimensions (arr[i-1] x arr[i]).

Example 1:

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explaination: There are 4 matrices of dimension
40x20, 20x30, 30x10, 10x30. Say the matrices are
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D.
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.

--> approach:
    the approach is to solve it recursively, find the minum of all the possible answers

 */
public class
parentProblem {
    static int matrixMultiplication(int N, int arr[])
    {

        // code here
        int[][] t= new int[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                t[i][j]=-1;
            }
        }
        return solve(arr,1,N-1,t);

    }
    static int solve(int[] arr, int i, int j,int[][] t){
        if(i>=j
        ){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        if(t[i][j]!=-1){
            return t[i][j];
        }
        for (int k = i; k < j; k++) {
            // here all the values of the loop are being compared to get min rather than being compared with int max every time.
            int temp=solve(arr,i,k,t)+solve(arr,k+1,j,t)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,temp);
        }
        return t[i][j]=min;
    }

}
