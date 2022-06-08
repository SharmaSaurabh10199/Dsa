package dataStructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InfectionSpread {
    public ArrayList<Integer>[] adj;

    public InfectionSpread(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdges(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
    int personsInfected(int source, int time,int V){
        int[] level= new int[adj.length];
       // boolean[] visited = new boolean[V];
        level[source]=1;
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
       // visited[source]=true;
        while (!q.isEmpty()){
            int curr= q.poll();
            if(level[curr]==time){
                break;
            }
            for(int neighbour: adj[curr]){
                if(level[neighbour]==0){
                    q.add(neighbour);
                    level[neighbour]=level[curr]+1;
                }
            }

        }
        int count=0;
        for (int i = 0; i < level.length; i++) {
            if(level[i]<=time && level[i]!=0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        InfectionSpread obj= new InfectionSpread(6);
        obj.connectEdges(0,1);
        obj.connectEdges(0,2);
        obj.connectEdges(0,5);
        obj.connectEdges(1,3);
        obj.connectEdges(2,4);
        System.out.println(obj.personsInfected(0,1,6));
    }
}
