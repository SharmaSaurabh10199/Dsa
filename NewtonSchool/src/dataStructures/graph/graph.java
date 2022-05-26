package dataStructures.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class graph {
    ArrayList<Integer>[] adj;
    public graph(int numVertices){
        adj= new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new ArrayList<>();
        }
    }
    private void connectEdges(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    private void dfsUtil(int source, boolean[] visited){
        visited[source]=true;
        System.out.print(" "+source);
        for(int neighbour: adj[source]){
            if(!visited[neighbour]){
                dfsUtil(neighbour,visited);
            }
        }
    }
    public void dfs(int source){
        boolean[] visited= new boolean[adj.length];
        dfsUtil(source,visited);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter number of vertices");
        int vertices= sc.nextInt();
        graph graph = new graph(vertices);
        System.out.println("enter no of edges");
        int numEdges= sc.nextInt();
        System.out.println("enter source and destination for edges");
        for(int i=0; i< numEdges; i++){
            int source= sc.nextInt();
            int destination= sc.nextInt();
            graph.connectEdges(source,destination);
        }
        graph.dfs(0);
    }

}
