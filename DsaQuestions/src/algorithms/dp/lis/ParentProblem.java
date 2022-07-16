package algorithms.dp.lis;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ParentProblem {
    static int lis(int[] arr, int n, int idx, int prev_idx,int[][] dp){
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev_idx+1]!=-1){
            return dp[idx][prev_idx+1];
        }
        int len= 0+ lis(arr,n,idx+1,prev_idx,dp);
        if(prev_idx==-1 || arr[idx]>arr[prev_idx]){
            len=Math.max(len, 1+lis(arr,n,idx+1,idx,dp));
        }
        return dp[idx][prev_idx+1] = len;
    }

    // the tabulation approach
    static int lis(int[] arr){
        int n= arr.length;
        int[][] dp= new int[n+1][n+1];
        for(int idx=n-1; idx>=0; idx--){
            for(int prev_idx=idx-1; prev_idx>=-1; prev_idx--){
                int len= 0+ dp[idx+1][prev_idx+1];
                if(prev_idx==-1 || arr[idx]>arr[prev_idx]){
                    dp[idx][prev_idx+1] =Math.max(len, 1+dp[idx+1][idx+1]);
                }
                return dp[idx][prev_idx+1] ;
            }
        }
        return dp[0][-1+1];
    }
    // one possible wrong way
    static int lisTrial(int[] arr){
        int res[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int count=1;
            int prev= arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(prev<arr[j]){
                    count++;
                    prev=arr[j];
                }
            }
            res[i]=count;
        }
        int max=0;
        for (int i = 0; i < res.length; i++) {
            max=Math.max(res[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,3,2,3};
        int[][] dp= new int[arr.length+1][arr.length+1];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        System.out.println(lis(arr,arr.length,0,-1,dp));
        System.out.println(lisTrial(arr));
    }
}
