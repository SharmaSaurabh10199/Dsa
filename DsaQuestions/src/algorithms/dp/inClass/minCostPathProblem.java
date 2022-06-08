package algorithms.dp.inClass;

import java.util.Arrays;

/*
problem statment: you have to go to bottom right cell, you can either go right or down, each cell gives the cost for travelling through that cell. find min cost
 */
public class minCostPathProblem {
    static int solveForMinCostPath(int[][] mat){
        int n= mat.length;
        int m= mat[0].length;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                if(i==n-1 && j==m-1){
                    mat[i][j]=mat[i][j];
                }
                else if(i==n-1){
                    mat[i][j]=mat[i][j]+mat[i][j+1];
                }
                else if(j==m-1){
                    mat[i][j]=mat[i][j]+mat[i+1][j];
                }
                else {
                    mat[i][j]=mat[i][j]+Math.min(mat[i][j+1],mat[i+1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(mat));
        return mat[0][0];

    }

    public static void main(String[] args) {
        int[][] mat={{2,7,6,4},{3,5,1,0},{7,8,6,4},{2,4,1,3}};
        solveForMinCostPath(mat);
    }

}
