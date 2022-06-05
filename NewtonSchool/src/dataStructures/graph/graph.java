package dataStructures.graph;

import java.util.*;

public class graph {
    public ArrayList<Integer>[] adj;

    public graph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdges(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    private void dfsUtil(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(" " + source);
        for (int neighbour : adj[source]) {
            if (!visited[neighbour]) {
                dfsUtil(neighbour, visited);
            }
        }
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[adj.length];
        dfsUtil(source, visited);
    }
    // to find the shortest distance between 2 nodes
    public int shortestDistance(int V, int S, int D, ArrayList<Integer>[] adj) {
        // Code here
        boolean[] visited = new boolean[V];
        int[] level = new int[V];
        level[S] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = true;
        while (!q.isEmpty()) {
            // don't mark true after polling it leads to errors.it duplicates
            int node = q.poll();
            // visited[node]=true;

            for (Integer item : adj[node]) {
                if (!visited[item]) {
                    level[item] = level[node] + 1;
                    visited[item] = true;
                    q.add(item);
                }
            }
        }
        // here the level array we have created is very useful, we can find all the nodes at a given distance.
        System.out.println(Arrays.toString(level));
        return level[D];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of vertices");
        int vertices = sc.nextInt();
        graph graph = new graph(vertices);
        System.out.println("enter no of edges");
        int numEdges = sc.nextInt();
        System.out.println("enter source and destination for edges");
        for (int i = 0; i < numEdges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.connectEdges(source, destination);
        }
        graph.shortestDistance(vertices, 2, 5, graph.adj);
    }

}
