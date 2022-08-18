package algorithms.dp.knapSack;

/*
Given an array arr[] of size N, check if it can be partitioned into two parts such that
the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination:
The two parts are {1, 5, 5} and {11}.


// approach: this problem is just a slight variation of subsetSum problem
    steps: 1) calculate the sum of the array
           2) if its odd, return false, lese proceed
           3) now check if for any subset with sum/2 exists or not.

 */
public class EqualPartitionProblem {
    static int equalPartition(int N, int arr[]) {
        // code here
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return 0;
        }
        if (solveByTabulation(N, sum / 2, arr)) {
            return 1;
        }
        return 0;
    }

    static boolean solveByTabulation(int n, int sum, int[] arr) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                }
            }
        }
        return t[n][sum];
    }
}
