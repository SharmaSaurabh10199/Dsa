package algorithms.dp.unboundedKnapSack;
/*
 You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

approach: here the meaning of each cell is "the minimum no of coins required to form the sum"
          and we have to initailize the first row because a coin may or may not form the the comibination.
 */
public class CoinChangeProblem2 {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount+1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(j == 0) {
                    dp[i][j] = 0;
                }
                else if(i == 0) {
                    // initialize with big number, so that this part doesn't affect our solution.
                    dp[i][j] = (int)1e5;
                }
                else if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[coins.length][amount] > (int)1e4 ? -1:dp[coins.length][amount];
    }

}
