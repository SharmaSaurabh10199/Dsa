package algorithms.dp.unboundedKnapSack;
/*
Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N.
 Determine the maximum value obtainable by cutting up the rod and selling the pieces.

 Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and

6, i.e., 5+17=22.

approach: it is basically same as unbounded knapsack problem, just that you have to form the length array by yourself

 */
public class RodCuttingProblem {
    public int cutRod(int price[], int n) {
        //code here
        int[][] t= new int[n+1][n+1];
        int[] wt= new int[n];
        for(int i=0; i<n; i++){
            wt[i]=i+1;
        }
        return solveIterative(n,wt, price, n, t);
    }
    static int solveIterative(int w, int[] wt, int[] val, int n, int[][] t){
        // intialisation can be avoided cause it alread has 0s.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if(wt[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                else {
                    t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
                }
            }
        }
        return t[n][w];
    }
}
