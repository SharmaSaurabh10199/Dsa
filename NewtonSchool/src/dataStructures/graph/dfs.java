package dataStructures.graph;

import java.util.ArrayList;

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
}
