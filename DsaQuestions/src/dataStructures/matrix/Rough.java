package dataStructures.matrix;

import java.util.Arrays;

public class Rough {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0}, {0, 0, 0}, {0, 1, 1}};
        booleanMat(mat,3,3);
        System.out.println(Arrays.deepToString(mat));
//        Scanner s= new Scanner(System.in);
//        int t= s.nextInt();
//        for (int i = 0; i < t; i++) {
//            int m=s.nextInt();
//            int n= s.nextInt();
//            int[][] mat= new int[m][n];
//            for (int j = 0; j < m; j++) {
//                for (int k = 0; k < n; k++) {
//                    mat[j][k]=s.nextInt();
//                }
//            }
//            booleanMat(mat,m,n);
//            for (int j = 0; j < m; j++) {
//                for (int k = 0; k < n; k++) {
//                    System.out.print(mat[j][k]+" ");
//                }
//                System.out.println();
//            }
//        }
    }
    public static void booleanMat(int[][]mat,int m , int n ){
       // int[] arr= new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==1){
                    mat[i][0]=1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(mat[i][0]==1){
                for (int j = 0; j < n; j++) {
                    mat[i][j]=1;
                }
            }
        }
    }

}
