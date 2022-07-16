package mockInterviews;

import java.util.LinkedList;
import java.util.Queue;

/*
0 1 2
0 1 2
2 1 1

solution: bfs
  steps: make a visited array,
         make a pair class for the row and column, push all the rotten tomatoes in queue
         now pop one, check if there is fresh tomatoes, push them in queue
         repeat untill the queue is empty
 */
class pair{
    int i;
    int j;
    public pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
public class RottenTomatos {

    int findTime(int[][] mat, int n, int m){

        Queue<pair> q= new LinkedList<>();
        boolean[][] visited= new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==2){
                    q.add(new pair(i,j));
                    visited[i][j]=true;
                }
            }
        }
        int time=0;
        while (!q.isEmpty()){
            int size= q.size();
            for (int i = 0; i < size; i++) {
                // push the neighbours if not visited
                pair p= q.poll();
                if(isValid(p.i-1,p.j,mat,visited)){
                    visited[p.i-1][p.j]=true;
                    q.add(new pair(p.i-1,p.j));
                }
                if(isValid(p.i,p.j-1,mat,visited)){
                    visited[p.i][p.j-1]=true;
                    q.add(new pair(p.i,p.j-1));
                }
                if(isValid(p.i+1,p.j,mat,visited)){
                    visited[p.i+1][p.j]=true;
                    q.add(new pair(p.i+1,p.j));
                }
                if(isValid(p.i,p.j+1,mat,visited)){
                    visited[p.i][p.j+1]=true;
                    q.add(new pair(p.i,p.j+1));
                }
            }
            time++;
        }
        return time;
    }
    boolean isValid(int i, int j, int[][] mat,boolean[][] visited){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j]==0 || visited[i][j]==true ){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        0 1 2
0 1 2
2 1 1
         */
        int[][] mat={{0,1,2},{0,1,2},{2,1,1}};
        RottenTomatos t= new RottenTomatos();
        System.out.println(t.findTime(mat, mat.length,mat[0].length));
    }
}
