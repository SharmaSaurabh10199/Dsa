package algorithms.dp.inClass;

import java.util.Arrays;

public class fibonachiOptimized {
    // non optimized
    static int  solve(int n){
        if(n==0 || n==1){
            return n;
        }
        return solve(n-1)+solve(n-2);
    }
    // optimized with memoization time complexity o(n), space complexity o(n)+o(n) stack + for array
    static int fib(int n, int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int fib1= fib(n-1,dp);
        int fib2= fib(n-2,dp);
        int fibn= fib1+fib2;
        dp[n]=fibn;
        return fibn;
    }
    // optimized with tabulation 0(1) recursive stack space
    static int fibTabulation(int n, int[] dp){
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // iterative soltion o(n) time, o(1) space
    static int fibIterative(int n){
        int prev1=0;
        int prev2=1;
        if(n<=1){
            return n;
        }
        for (int i = 2; i <=n ; i++) {
            int curr= prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return prev2;
    }


    public static void main(String[] args) {
        int n=40;
        int[] dp= new int[n+1];
        System.out.println(fib(n,dp));
        System.out.println(fibIterative(40));
    }
}
