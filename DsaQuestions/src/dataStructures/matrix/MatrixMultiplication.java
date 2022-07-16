package dataStructures.matrix;

import java.util.Arrays;

/*
you are given the matrices a nad b, you have to multiply a nad b. print the result;
 */
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a={{3,1},{1,2},{2,4}};
        int[][] b={{1,3,2},{2,4,3}};
        matrixMultiplication(a,b);
    }
    public static void matrixMultiplication(int[][] a, int[][] b){
        if(a[0].length!=b.length){
            return;
        }
        int[][] c= new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                int k=0,res=0;
                while (k<b.length){
                    res+=a[i][k]*b[k][j];
                    k++;
                }
                c[i][j]=res;
               // System.out.print(c[i][j]+" ");
            }
           // System.out.println();

        }
        System.out.println(Arrays.deepToString(c));
    }
}

