package dataStructures.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class dfs {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res= new ArrayList();
        boolean[] visited= new boolean[V+1];
        // considering 0 based indexing
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfsUtil(0,res,adj,visited);
            }
        }
        return res;
    }
    void dfsUtil(int index,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[index]=true;
        res.add(index);
        for(Integer neighbour: adj.get(index)){
            if(!visited[neighbour]){
                dfsUtil(neighbour,res,adj,visited);
            }
        }

    }
    // dfs using adj matrix
    static void dfsMat(int i, boolean[] visited, int[][] mat){
        visited[i]=true;
        for(int j=0; j<mat[0
                ].length; j++){
            if(!visited[j] && mat[i][j]==1){
                dfsMat(j,visited,mat);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m= sc.nextInt();
        int[][] mat= new int[n][m];
        boolean[] visited= new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j]=sc.nextInt();
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfsMat(i,visited,mat);
            }
        }
        System.out.println(count);
    }
}
