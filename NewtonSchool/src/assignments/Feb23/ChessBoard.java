package assignments.Feb23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Tom loves Chess boards. He admires its symmetry and how the black and white colours are placed adjacently along both the axis.
On his birthday, Tom has been gifted a board which is in the form an NxN grid. Every cell is painted either black or white.
 Since Tom loves the placement of colours in a chessboard, he will try to convert the board that has been gifted to him identical to
 a chessboard. He has both black and white colours available to him. Help him find out the minimum number of the cell he will have to recolour
  to get a chessboard like board.
Input
First line contains an integer N, denoting the size of the board
Next N lines contains N space separated integers and each integer being either '0' or '1'
'1' represent black cell
'0' represents white cell
 */
public class ChessBoard {
    public static void main(String[] args) throws IOException {
        int d1=0, d2=0;
//        Scanner s= new Scanner(System.in);
//        int n= s.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int[][] mat= new int[n][n];
        for(int i=0;i<n;i++){
            str = br.readLine().trim().split(" ");
            for(int j=0;j<n;j++){
                mat[i][j] = Integer.parseInt(str[j]);
//
                if ((i + j) % 2 == 0) {
                    if (mat[i][j] != 1) {
                        d1++;
                    }
                    if (mat[i][j] != 0) {
                        d2++;
                    }

                } else if ((i + j) % 2 != 0) {
                    if (mat[i][j] != 0) {
                        d1++;
                    }
                    if (mat[i][j] != 1) {
                        d2++;
                    }
                }
            }
        }
        System.out.println(Math.min(d1,d2));
    }

    public static int minColours(int[][] mat, int n) {
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    if (mat[i][j] != 1) {
                        d1++;
                    }
                    if (mat[i][j] != 0) {
                        d2++;
                    }

                } else if ((i + j) % 2 != 0) {
                    if (mat[i][j] != 0) {
                        d1++;
                    }
                    if (mat[i][j] != 1) {
                        d2++;
                    }
                }
            }
        }
        return Math.min(d1,d2);
    }
}
