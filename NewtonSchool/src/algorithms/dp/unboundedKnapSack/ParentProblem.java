package algorithms.dp.unboundedKnapSack;
/*
Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Input: N = 2, W = 3
val[] = {1, 1}
wt[] = {2, 1}
Output: 3
Explanation:
1.Pick the 2nd element thrice.
2.Total profit = 1 + 1 + 1 = 3. Also the total
  weight = 1 + 1 + 1  = 3 which is <= W.

  Constraints:
1 ≤ N, W ≤ 1000
1 ≤ val[i], wt[i] ≤ 100

  approach:
  this is almost same problem as previous problem just that now the choices change, for a perticular number at n-1, we can choose it
  for as many as times we want, but we wont choose it if we don't use it.
 */
public class ParentProblem {
    static int unboundedKnapSack(int w, int[] wt, int[] val, int n, int[][] t){
        // intialisation can be avoided cause it alread has 0s.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if(wt[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                else {
                    t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
                }
            }
        }
        return t[n][w];
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] t= new int[N+1][W+1];
        return unboundedKnapSack(W,wt,val,N,t);
    }
}
