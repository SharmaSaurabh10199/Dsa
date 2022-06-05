package dataStructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the BFS
traversal
of the graph starting from the 0th vertex, from left to right according to the graph.
Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


Example 1:

Input:

Output: 0 1 2 3 4
Explanation:
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3.After this 2 to 4, thus bfs will be
0 1 2 3 4.


 */
public class bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited= new boolean[V+1];
        ArrayList<Integer> bfs= new ArrayList<>();
        for (int i = 1; i <=V ; i++) {
            if(!visited[i]){
                Queue<Integer> q= new LinkedList<>();
                q.add(i);
                visited[i]=true;
                while (!q.isEmpty()){
                    // don't mark true after polling it leads to errors.it duplicates, because if the graph is cyclic you will
                    // end up visiting one node twice, and hence its neighbours.
                    int node= q.poll();
                   // visited[node]=true;
                    bfs.add(node);
                    for(Integer item: adj.get(node)){
                        if(!visited[item]){
                            visited[item]=true;
                            q.add(item);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}
