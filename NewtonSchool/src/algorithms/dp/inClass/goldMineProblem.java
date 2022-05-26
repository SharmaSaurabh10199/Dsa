package algorithms.dp.inClass;

import java.util.Arrays;

/*
Given a gold mine called M of (n x m) dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
 Initially the miner can start from any row in the first column. From a given cell, the miner can move

to the cell diagonally up towards the right
to the right
to the cell diagonally down towards the right
Find out maximum amount of gold which he can collect.


Example 1:

Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination:
The path is {(1,0) -> (2,1) -> (2,2)}.
 */
public class goldMineProblem {
    static int maxGold(int n, int m, int mat[][])
    {
        // code here
        // processing the matrix
        for (int j = m-1; j >=0 ; j--) {
            for (int i = n-1; i >=0 ; i--) {
                if(j==m-1){
                    continue;
                }
                else if(i==n-1 && i==0){
                    mat[i][j]=mat[i][j]+mat[i][j+1];
                }

                else if(i==n-1){
                    mat[i][j]=mat[i][j]+Math.max(mat[i][j+1],mat[i-1][j+1]);
                }
                else if(i==0){
                    mat[i][j]=mat[i][j]+Math.max(mat[i][j+1],mat[i+1][j+1]);
                }
                else {
                    mat[i][j]=mat[i][j]+Math.max(mat[i][j+1],Math.max(mat[i-1][j+1],mat[i+1][j+1]));
                }
            }
        }
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(max<mat[i][0]){
                max=mat[i][0];
            }
        }
        System.out.println(Arrays.deepToString(mat));
        return max;
    }

    public static void main(String[] args) {
        int[][] mat={{1, 3, 4},
                };
        maxGold(1,3,mat);
    }
}
