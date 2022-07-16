package rough;

import java.util.Arrays;
import java.util.Scanner;

public class CollectCoins {

    public static void main (String[] args) {
        // Your code here
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
    }

    public static long findCoin(int[] arr, int n, long[] dp){
        if(n<1){
            return 0;
        }
        else if(dp[n]!=-1){
            return dp[n];
        }
        else return dp[n] = Math.max((arr[n - 1] + findCoin(arr, n - 2, dp)), findCoin(arr, n - 1, dp));
    }
}
