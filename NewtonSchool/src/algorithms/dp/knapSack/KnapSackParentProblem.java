package algorithms.dp.knapSack;

public class
KnapSackParentProblem {
    static int knapSack(int w, int wt[], int val[], int n)
    {
        // your code here
        int[][] dp= new int[w+1][n+1];
        return solve(wt,val,n,w,dp);

    }
    // memoizatio approach

    static int solve(int[] wt, int[] val, int n, int w,int[][] dp){
        if(n==0 || w<=0){
            return 0;
        }
        if(dp[w][n]!=0){
            return dp[w][n];
        }
        else if(wt[n-1]>w){
            return dp[w][n]=solve(wt,val,n-1,w,dp);
        }
        else {
            return dp[w][n]=Math.max((val[n-1]+solve(wt,val,n-1,w-wt[n-1],dp)),solve(wt,val,n-1,w,dp));
        }
    }
    // tabulation approach
    static int solveIterative(int w, int[] wt, int[] val, int n, int[][] t){
        // intialisation can be avoided cause it alread has 0s.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
               if(wt[i-1]>w){
                   t[i][j]=t[i-1][j];
               }
               else {
                   t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
               }
            }
        }
        return t[n][w];
    }
}
