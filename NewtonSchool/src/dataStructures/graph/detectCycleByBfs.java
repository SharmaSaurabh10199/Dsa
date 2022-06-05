package dataStructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detectCycleByBfs {
    class pair{
        int curr;
        int parent;
        public pair(int curr, int prev){
            this.curr=curr;
            this.parent=prev;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited= new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(hasCycle(i,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasCycle(int index,ArrayList<ArrayList<Integer>> adj,boolean[] visited ){
        visited[index]=true;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(index,-1));
        while (!q.isEmpty()){
            int curr= q.peek().curr;
            int parent= q.peek().parent;
            q.poll();
            for(Integer neighbour: adj.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(new pair(neighbour,curr));
                }
                else if(parent!=neighbour){
                    return true;
                }
            }
        }
        return false;
    }
    // another approach: if there is cycle, one of the element of the cycle will be pushed 2twice in the queue,
    // we just have to check that.
    public boolean hasCycleANotherApproach(int index,ArrayList<ArrayList<Integer>> adj,boolean[] visited ){
        //visited[index]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()){
            int curr= q.poll();
            if(visited[curr]){
                return true;
            }
            visited[curr]=true;
            for(int neighbour: adj.get(curr)){
                if(!visited[neighbour]){
                    q.add(neighbour);
                }
            }
        }
        return false;

    }
}
