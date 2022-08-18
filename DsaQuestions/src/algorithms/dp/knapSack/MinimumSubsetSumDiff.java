package algorithms.dp.knapSack;

import java.util.ArrayList;

/*
Partition a set into two subsets such that the difference of subset sums is minimum

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11



// approach to this problem
  1)  calculate the sum of the array, s2 = sum-s1;
  1 s2-s1 is nothing but, sum-2s1, now we have to minimize this.
  3) this is same as subset problem, find all the possible valuse of s1 such that it is s1<sum/2 because we have to find the abso;ute result.
  4) create a table for given sum ans sum, and create a vector such that it contains all values of s1 which exists (from subset problem)
 */
public class MinimumSubsetSumDiff {

    static public int minDifference(int arr[], int n) {
        // Your code goes here
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        int min = Integer.MAX_VALUE;
        boolean[][] table = solveByTabulation(arr.length, sum, arr);
        ArrayList<Integer> ls = new ArrayList<>();
        // i<sum/2 doesnt give results
        for (int i = 0; i <= sum / 2; i++) {
            if (table[n][i]) {
                ls.add(i);
            }
        }
        for (Integer item : ls) {
            if (min > (sum - 2 * item)) {
                min = sum - 2 * item;
            }
        }
        System.out.println(min);
        return min;
    }

    static boolean[][] solveByTabulation(int n, int sum, int[] arr) {
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
        return t;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 6, 5, 11 };
        minDifference(arr, arr.length);

    }
}
