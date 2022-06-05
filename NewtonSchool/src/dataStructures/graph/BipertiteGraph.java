package dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
check if the given graph is bipertite or not, a graph is bipertite if it can be colored with 2 diff colors, with adjcent nodes being
diff colored
 */
public class BipertiteGraph {
    public boolean isBipertite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color= new int[V];
        Arrays.fill(color,-1);

        for (int i = 0; i < V; i++) {
            if(color[i]==-1){
                if(!bfsUtil(color,adj,i)){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean bfsUtil(int[] color, ArrayList<ArrayList<Integer>> adj, int idx ){
        Queue<Integer> q= new LinkedList<>();
        q.add(idx);
        color[idx]=1;
        while (!q.isEmpty()){
            int curr= q.poll();
            for(int neighbour: adj.get(curr)){
                if(color[neighbour]==-1){
                    q.add(neighbour);
                    // changing the color for ther neighbours
                    color[neighbour]=1-color[curr];
                }  // checking if the color of neighbour are same or not if it has already been visited.
                else if(color[neighbour]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}
