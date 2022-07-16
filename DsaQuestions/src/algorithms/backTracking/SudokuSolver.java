package algorithms.backTracking;

import java.util.Arrays;

/*
this problem is similar to the n queen problem,
  approach:
     1) iterate through the matrix,
     2) for every empty index, place values between from 1 tpo 9, and if the placeed value is valid,
       now recursivly call for sudoku, if its return true,else return false;
     3) if sudoku returns false, remove the placed value and iteratre for the next number,

 */
public class SudokuSolver {
    public boolean sudokuSolver(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (sudokuSolver(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
            if (board[3 *(row / 3) + i / 3][3*(col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s= new SudokuSolver();
        int[][] grid={ { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if(s.sudokuSolver(grid)){
            for(int[] item: grid){
                System.out.println(Arrays.toString(item));
            }
        }
        else {
            System.out.println("no solution exists");
        }
    }

}
