package algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;

/*

Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1},
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at
(3, 3) from (0, 0) by two paths - DRDDRR
and DDRDRR, when printed in sorted order
we get DDRDRR DRDDRR.
 */


// dry run is very importanrt in this question
public class RatInmaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans= new ArrayList<>();
        int[][] vis= new int[n][n];
        // Your code here  dlru
        solve(0,0,m,n,vis,ans,"");
        return ans;
    }
    public static void solve(int i, int j,int[][] maze, int n, int[][] vis, ArrayList<String> ans,String move){
        if(i==n-1 && j==n-1){
            ans.add(move);
            return;
        }
        //down
        if(i+1<n && vis[i+1][j]!=1 && maze[i+1][j]!=0 ){
            vis[i][j]=1;
            solve(i+1,j,maze,n,vis,ans,move+"D");
            vis[i][j]=0;
        }
        // left
        if(j-1>=0 && vis[i][j-1]!=1 && maze[i][j-1]!=0 ){
            vis[i][j]=1;
            solve(i,j-1,maze,n,vis,ans,move+"L");
            vis[i][j]=0;
        }
        //right
        if(j+1<n && vis[i][j+1]!=1 && maze[i][j+1]!=0 ){
            vis[i][j]=1;
            solve(i,j+1,maze,n,vis,ans,move+"R");
            vis[i][j]=0;
        }
        // up
        if(i-1>=0 && vis[i-1][j]!=1 && maze[i-1][j]!=0 ){
            vis[i][j]=1;
            solve(i-1,j,maze,n,vis,ans,move+"U");
            vis[i][j]=0;
        }
    }

    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findPath(m,m.length));;
    }
}
