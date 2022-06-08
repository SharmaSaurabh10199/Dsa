package algorithms.dp.inClass;

public class NStairs {
    // memoization approach
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
    // tabulation approach
    static int solveBottonUp(int n, int[] dp){
        dp[0]=1;
        for (int i = 1; i <=n ; i++) {
            if(i==1 || i==2){
                dp[i]=i;
            }
            else {
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n= 6;
        int[] dp= new int[n+1];
        System.out.println(solveBottonUp(n,dp));

    }
}
