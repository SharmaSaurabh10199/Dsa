package algorithms.backTracking;

/*
Given a 2-Dimensional character array and a string, we need to find the given string in 2-dimensional character array such that individual characters can be present left to right, right to left, top to down or down to top.

Examples:

Input : a ={
            {D,D,D,G,D,D},
            {B,B,D,E,B,S},
            {B,S,K,E,B,K},
            {D,D,D,D,D,E},
            {D,D,D,D,D,E},
            {D,D,D,D,D,G}
           }
        str= "GEEKS"
Output :2
 */
public class WordSolver {

    int countWords(char[][] board, String str) {
        int res=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               res+= solve(board, str, 0, i, j, board.length);
            }
        }
        return res;
    }

    int  solve(char[][] board, String str, int index, int i, int j, int n) {

        int found=0;
        if(i>=0 && j>=0 && i<n && j<n && board[i][j]==str.charAt(index)){
            char temp= board[i][j];
            index+=1;

            if(index==str.length()){
                found=1;
            }
            else {
                board[i][j]='0';

                found+=solve(board, str, index, i+1, j, n);
                found+=solve(board, str, index, i-1, j, n);
                found+=solve(board, str, index, i, j+1, n);
                found+=solve(board, str, index, i, j-1, n);
                board[i][j]=temp;
            }


        }
        return found;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(wordSearch(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;


    }
    boolean wordSearch(char[][] board, String str,int index, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=str.charAt(index)){
            return false;
        }
        index++;
        if(index==str.length()){
            return true;
        }
        char temp=board[i][j];
        board[i][j]=0;
        if(wordSearch(board, str, index, i+1, j)){
            return true;
        }
        else if(wordSearch(board, str, index, i-1, j)){
            return true;
        }
        else if(wordSearch(board, str, index, i, j-1)){
            return true;
        }
        else if(wordSearch(board, str, index, i, j+1)){
            return true;
        }
        board[i][j]= temp;
        return false;
    }


    public static void main(String[] args) {
        WordSolver obj= new WordSolver();
        char[][] grid={
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'},};
        System.out.println(obj.exist(grid,"SEE"));

    }

}
