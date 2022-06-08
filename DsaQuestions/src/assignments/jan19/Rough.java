package assignments.jan19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rough {
    public static void main(String[] args) throws IOException {
//        int[][] mat = {{1, 0, 0}, {0, 0, 0}, {0, 1, 1}};
        // Scanner s= new Scanner(System.in);
        BufferedReader s = new BufferedReader (new InputStreamReader(System.in));
        int t=Integer.parseInt(s.readLine());
        for (int i = 0; i < t; i++) {
            int m= Integer.parseInt(s.readLine());
            int n= Integer.parseInt(s.readLine());
            int[][] mat= new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k]=Integer.parseInt(s.readLine());
                }
            }
            booleanMat(mat,m,n);
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(mat[j][k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void booleanMat(int[][]mat,int m , int n ){
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
