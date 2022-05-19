package algorithms.backTracking;

import java.util.Arrays;

public class NQueen {
    boolean isValid(int[][] board,int row, int col){
        for (int i = 0; i < row; i++) {
            if(board[i][col]==1){
                return false;
            }
        }
        int x=row;
        int y=col;
        while (x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y--;
        }
        int xdia=row;
        int ydia=col;
        while (xdia>=0 && ydia<board.length){
            if(board[xdia][ydia]==1){
                return false;
            }
            xdia--;
            ydia++;
        }
        return true;
    }
    boolean nQueens(int[][] board, int row){
        if(row==board.length){
            return true;
        }
        for (int col = 0; col < board.length; col++) {
            if(isValid(board,row,col)){
                board[row][col]=1;
                if(nQueens(board,row+1)){
                    return true;
                }
                board[row][col]=0;
            }
        }
        return false;
    }
    // finding all the existing solutions
    void solveForAllSolutions(int[][] board, int row){
        if(row==board.length){
            print(board, board.length);
            return ;
        }
        for (int col = 0; col < board.length; col++) {
            if(isValid(board,row,col)){
                board[row][col]=1;
                solveForAllSolutions(board,row+1);
                board[row][col]=0;
            }
        }
       // return ;
    }
    void print(int[][] board, int n){
        for(int[] item: board){
            System.out.println(Arrays.toString(item));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[][]baord= new int[4][4];
        NQueen q= new NQueen();
//        if(q.nQueens(baord,0)){
//            System.out.println("Solution exists");
//            System.out.println(Arrays.deepToString(baord));
//        }
//        else{
//            System.out.println("no solution exists");
//        }
        q.solveForAllSolutions(baord,0);

    }
}
