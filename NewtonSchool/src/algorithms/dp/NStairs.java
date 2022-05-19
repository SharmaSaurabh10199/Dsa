package algorithms.dp;

public class NStairs {
    static int solve(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int x= solve(n-1,dp);
        int y= solve(n-2,dp);
        int z= solve(n-3,dp);
        dp[n]=x+y+z;
        return x+y+z;
    }

    public static void main(String[] args) {
        int n= 3;
        int[] dp= new int[n+1];
        System.out.println(solve(n,dp));

    }
}
