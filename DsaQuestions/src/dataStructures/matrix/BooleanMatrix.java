package dataStructures.matrix;

import java.util.Arrays;

/*
Given a boolean matrix of size RxC where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j]


is 1 then all the cells in its ith row and jth column will become 1.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
              {0, 0}}
Output:
1 1
1 0
Explanation:
Only cell that has 1 is at (0,0) so all
cells in row 0 are modified to 1 and all
cells in column 0 are modified to 1.

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
              { 1, 0, 0},
              { 1, 0, 0},
              { 0, 0, 0}}
Output:
1 1 1
1 1 1
1 1 1
1 0 0
 */
public class BooleanMatrix {
    public static void main(String[] args) {
         int matrix[][] = {{ 1, 0, 0},
                 { 1, 0, 0},
                 { 1, 0, 0},
                 { 0, 0, 0}};
         modifyBooleanMat(matrix,matrix.length,matrix[0].length);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void modifyBooleanMat(int[][] mat,int n , int m){
        int[] row= new int[n];
        int[] col= new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(mat[i][j]==1){
                   row[i]=1;
                   col[j]=1;
               }
            }
        }
        for (int i = 0; i < n; i++) {
            if(row[i]==1){
                for (int j = 0; j < m; j++) {
                    mat[i][j]=1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(col[i]==1){
                for (int j = 0; j < n; j++) {
                    mat[j][i]=1;
                }
            }
        }
    }
}
