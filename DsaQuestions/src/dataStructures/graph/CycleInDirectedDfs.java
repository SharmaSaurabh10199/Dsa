package dataStructures.graph;

import java.util.ArrayList;

public class CycleInDirectedDfs {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited= new int[V];
        int[] dfsVisited= new int[V];
        for (int i = 0; i < V; i++) {
            if(dfsUtil(visited,dfsVisited,i,adj)){
                return true;
            }
        }
        return false;
    }
    public boolean dfsUtil(int[] visited, int[] dfsVisited, int idx,ArrayList<ArrayList<Integer>> adj){
        visited[idx]=1;
        dfsVisited[idx]=1;
        for(int neighbour: adj.get(idx)){
            if(visited[neighbour]==0){
                if(dfsUtil(visited,dfsVisited,neighbour,adj)){
                    return true;
                }
            }
            else if(dfsVisited[neighbour]==1){
                return true;
            }
        }
        dfsVisited[idx]=0;
        return false;
    }
}
