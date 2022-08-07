package dataStructures.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1

//   Solution:
    push all the rotten oranges in the queue, have a count of the total oranges too.
    apply the bfs, rott the neighbour oranges and untill the queue is empty

 */
public class RottenOranges {
    static class pair{
        int i;
        int j;
        public pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    static public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int totalOranges=0;
        int rottenOranges=0;
        int days=0;
        Queue<pair> q= new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!=0){
                    totalOranges++;
                }
                if(grid[i][j]==2){
                    q.add(new pair(i,j));
                }
            }
        }
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        while (!q.isEmpty()){
            int k=q.size();
            rottenOranges+=k;
            for (int i = 0; i < k; i++) {
                pair p= q.poll();
                for (int j = 0; j < 4; j++) {
                    int newX=p.i+dx[j];
                    int newY= p.j+dy[j];
                    // skipping the invalid matrix entries and also the already rotten and empty cells
                    if(newX<0 || newY<0 || newX>=m || newY>=n || grid[newX][newY]!=1) continue;
                    // making the orange rotten
                    grid[newX][newY]=2;
                    q.add(new pair(newX,newY));
                }
            }
            if(!q.isEmpty()) days++;
        }
        return totalOranges==rottenOranges? days: -1;
    }

    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    static boolean inAnagram(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap<Character,Integer> hm= new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            hm.put(str1.charAt(i), hm.getOrDefault(str1.charAt(i),0)+1);
        }
        for (int i = 0; i < str2.length(); i++) {
            if(hm.containsKey(str2.charAt(i))){
                hm.put(str2.charAt(i),hm.get(str2.charAt(i))-1);
                if(hm.get(str2.charAt(i))==0){
                    hm.remove(str2.charAt(i));
                }
            }
            else {
                return false;
            }
        }
        return hm.size()==0;
    }

}
