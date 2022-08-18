package dataStructures.matrix;
/*
Given a matrix of n x n size, the task is to find the saddle point of the matrix.
A saddle point is an element of the matrix such that
it is the minimum element in its row and maximum in its column.
Examples :


Input: Mat[3][3] = { {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9}}
Output: 7
7 is minimum in its row and maximum in its column.
 */
public class SaddlePoint {
    public static void main(String[] args) {
        int[][] arr={ {1, 2, 3},
                {0, 5, 6},
                {-1, 8, 9}};
        System.out.println(saddlePoint(arr));
    }
    public static int saddlePoint(int[][] mat){
        int res=-1;

        for (int i = 0; i < mat.length; i++) {
          int curr= mat[i][0], curColom=0;
            for (int j = 0; j < mat[0].length; j++) {
                if(curr>mat[i][j]){
                    curr=mat[i][j];
                    curColom=j;
                }
            }
            boolean flag=true;
            for (int j = 0; j < mat.length; j++) {
                if(mat[j][curColom]>curr){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                res=curr;
                break;
            }

        }
        return res;
    }
}
