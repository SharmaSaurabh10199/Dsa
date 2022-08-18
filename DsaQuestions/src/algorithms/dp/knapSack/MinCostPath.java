package algorithms.dp.knapSack;

import java.util.Scanner;

public class MinCostPath {
    static int minCostPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    t[i][j] = grid[i][j];
                } else if (i == m - 1) {
                    t[i][j] = grid[i][j] + t[i][j + 1];
                } else if (j == n - 1) {
                    t[i][j] = grid[i][j] + t[i + 1][j];
                } else {
                    t[i][j] = grid[i][j] + Math.min(t[i + 1][j], t[i][j + 1]);
                }
            }
        }
        return t[0][0];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        System.out.println(minCostPath(matrix));
    }
}
