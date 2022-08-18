package dataStructures.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Given an NxM 2D matrix, rearrange such that
Each diagonal in the lower left triangle of the rectangular grid is sorted in ascending order.
Each diagonal in the upper right triangle of the rectangular grid is sorted in descending order.
The major diagonal in the grid starting from the top-left corner is not rearranged.
N = 4, M = 5
matrix = {{3 6 3 8 2},
          {4 1 9 5 9},
          {5 7 2 4 8},
          {8 3 1 7 6}}
Output:
3 9 8 9 2
1 1 6 5 8
3 4 2 6 3
8 5 7 7 4
 */
public class SortMatrixDiagonally {
    public static void main(String[] args) {
        int[][] mat = { { 3, 6, 3, 8, 2 },
                { 4, 1, 9, 5, 9 },
                { 5, 7, 2, 4, 8 },
                { 8, 3, 1, 7, 6 } };
        sorltDiagonally(mat, mat.length, mat[0].length);
        System.out.println(Arrays.deepToString(mat));
    }

    public static void sorltDiagonally(int[][] mat, int n, int m) {
        // sort the upper triangle first:
        for (int i = 1; i < m; i++) {
            ArrayList<Integer> ls = new ArrayList<>();
            int c = 0, j = i;
            while (c < n && j < m) {
                ls.add(mat[c++][j++]);
            }
            c = 0;
            j = i;
            Collections.sort(ls, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int x : ls) {
                mat[c++][j++] = x;
            }

        }
        // sort the lower triangle
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> ls = new ArrayList<>();
            int c = i, j = 0;
            while (c < n) {
                ls.add(mat[c++][j++]);
            }
            c = i;
            j = 0;
            Collections.sort(ls, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int x : ls) {
                mat[c++][j++] = x;
            }

        }
    }
}
