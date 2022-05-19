package dataStructures.matrix;

import java.util.Arrays;

/*
given a square matrix, you have to do the transpose of this matrix in O(1);
 */
public class TransposeOfSquareMatrix {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        transpose(mat,mat.length,mat[0].length);
        System.out.println(Arrays.deepToString(mat));
    }
    public static void transpose(int[][] mat,int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < m; j++) {
                int temp= mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
}
