package dataStructures.matrix;

import java.util.Arrays;

/*
Given a square matrix[][] of size N x N. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.

Example 1:

Input:
N = 3
matrix[][] = [[1 2 3],
              [4 5 6],
              [7 8 9]]
Output:
3 6 9
2 5 8
1 4 7
 */
public class RotationBy90Degree {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
    //   rotateby90(mat,mat.length,mat[0].length);
      //  System.out.println(Arrays.deepToString(mat));
        rotateClockwiseby90(mat,mat.length,mat[0].length);
        System.out.println(Arrays.deepToString(mat));
    }
    // rotating anticlockwise
    public static void rotateby90(int[][] mat,int n, int m){
        transpose(mat,n,m);
        reverseRows(mat);
    }
    // rotate clockwise

    public static void rotateClockwiseby90(int[][] mat,int n, int m){
        transpose(mat,n,m);
        reverseCols(mat);
    }

    public static void transpose(int[][] mat,int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < m; j++) {
                if(i!=j){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
    }
    public static void reverseRows(int[][] mat){
        int i=0, j=mat.length-1;
        while (i<j){
            int[] temp=mat[i];
            mat[i]=mat[j];
            mat[j]=temp;
            i++;
            j--;
        }
    }
    public static void reverseCols(int[][] mat){
        int n=mat.length; int m= mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp= mat[i][j];
                mat[i][j]=mat[i][m-j-1];
                mat[i][m-j-1]=temp;
            }
        }
    }

}
