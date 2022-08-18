package algorithms.dp.lis;

import java.util.Arrays;

public class ParentProblem {
    public static int lis1d(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        // every position have atleast 1 increasing sequence
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // if we find increasing seq, add it to the prev value
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // now find the maximum out of it
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 2, 3 };
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

    }
}
