package dataStructures.graph;

import java.util.ArrayList;
/*
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.

solution: if there is a cycle, then the neighbour of node will be visited that being not his parent.
 */
public class DetectCycle {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited= new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(dfs(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int index, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent ){
        visited[index]=true;
        for(int neighbour: adj.get(index)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,index)){
                    return true;
                }
            }
            else if(parent!= neighbour ){
                return true;
            }
        }
        return false;
    }
}
