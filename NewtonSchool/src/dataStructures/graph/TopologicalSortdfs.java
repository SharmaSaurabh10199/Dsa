package dataStructures.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortdfs {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] visited= new boolean[V];
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfsUtil(st,visited,i,adj);
            }
        }
        int[] res= new int[V];
        int i=0;
        while (!st.isEmpty()){
            res[i++]=st.pop();
        }
        return res;
    }
    static void dfsUtil(Stack<Integer> st, boolean[] visited, int idx,ArrayList<ArrayList<Integer>> adj){
        visited[idx]=true;
        for(int neighbour: adj.get(idx)){
            if(!visited[neighbour]){
                dfsUtil(st,visited,neighbour,adj);
            }
        }
        st.push(idx);
    }
}
