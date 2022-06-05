package dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipertiteByDfs {
    public boolean isBipertite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color= new int[V];
        Arrays.fill(color,-1);

        for (int i = 0; i < V; i++) {
            if(color[i]==-1){
                color[i]=1;
                if(!dfsUtil(color,adj,i)){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean dfsUtil(int[] color,ArrayList<ArrayList<Integer>> adj, int idx){
        for(int neighbour: adj.get(idx)){
            if(color[neighbour]==-1){
                color[neighbour]=1-color[idx];
                if(!dfsUtil(color,adj,neighbour)){
                    return false;
                }
            }
            else if(color[neighbour]!=color[idx]){
                return false;
            }
        }
        return true;
    }
}
