package algorithms.dp.unboundedKnapSack;
/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
valued coins, how many ways can we make the change? The order of coins doesn’t matter.
Example:
for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.

approach: this is just the unbounded version solution of subset sum problem.
 */
public class CoinChangeProblem {
    static int solveByTabulation(int n , int sum, int[] coin){
        int[][] t= new int[n+1][sum+1];
        t[0][0]=1;
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(coin[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                else {                 // i still gives choice to us, just that bit variation works fine.
                    t[i][j]=t[i-1][j] + t[i][j-coin[i-1]];
                }
            }
        }
        return t[n][sum];
    }
}
