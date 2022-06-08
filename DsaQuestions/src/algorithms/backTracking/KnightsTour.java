package algorithms.backTracking;

import java.util.Arrays;

/*
Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each cell in which they are visited.

Example:

Input :
N = 8
Output:
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12
 */
public class KnightsTour {
    void solve(int i, int j, int[][] board, int move, int n){
        if(move>n*n){
            print(board,n);
            return;
        }
        if(i <0 || j <0 || i>=n || j>=n || board[i][j]!=0){
            return;
        }
        board[i][j]=move;
        solve(i-2,j-1,board,move+1,n);
        solve(i-2,j+1,board,move+1,n);
        solve(i-1,j+2,board,move+1,n);
        solve(i+1,j+2,board,move+1,n);
        solve(i+2,j+1,board,move+1,n);
        solve(i+2,j-1,board,move+1,n);
        solve(i+1,j-2,board,move+1,n);
        solve(i-1,j-2,board,move+1,n);
        board[i][j]=0;
    }
    // the desired solution
    boolean solveFor1Solution(int i, int j, int[][] board, int move, int n){
        if(move>n*n){
            print(board,n);
            return true;
        }
        if(i <0 || j <0 || i>=n || j>=n || board[i][j]!=0){
            return false;
        }
        board[i][j]=move;
        if(solveFor1Solution(i-2,j-1,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i-2,j+1,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i-1,j+2,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i+1,j+2,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i+2,j+1,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i+2,j-1,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i+1,j-2,board,move+1,n)){
            return true;
        }
        else if(solveFor1Solution(i-1,j-2,board,move+1,n)){
            return true;
        }
        board[i][j]=0;
        return false;
    }
    void print(int[][] board, int n){
        for(int[] item: board){
            System.out.println(Arrays.toString(item));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] grid= new int[5][5];
        KnightsTour k= new KnightsTour();
        k.solveFor1Solution(0,0,grid,1,grid.length);
    }

}
