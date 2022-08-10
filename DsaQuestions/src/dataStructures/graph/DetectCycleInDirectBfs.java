package dataStructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectBfs {
    public boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<V; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int curr= q.poll();
            count++;
            for(int iter: adj.get(curr)){
                inDegree[iter]--;
                if(inDegree[iter]==0){
                    q.add(iter);
                }
            }
        }
        // the count will always be less than no of nodes in case of cycle

        return count<V;
    }
}
