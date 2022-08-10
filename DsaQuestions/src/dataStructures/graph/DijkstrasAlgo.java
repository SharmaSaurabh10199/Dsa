package dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*  problem statment: 
Given a graph and a source vertex in the graph, find the shortest paths
from the source to all vertices in the given graph. */
public class DijkstrasAlgo {
    class Node {
        int v;
        int w;

        public Node(int v, int weight) {
            this.v = v;
            this.w = weight;
        }
    }

    int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int S) {
        // Write your code here
        // a minheap on the basis of the distance from the source node
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        int[] distance = new int[V];
        // assume first that all nodes are at infinity distance
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Node(0, 0));
        distance[0] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node it : adj.get(node.v)) {
                // push in queue id the distance is smaller than the curr distance

                if (distance[node.v] + it.w < distance[it.v]) {
                    distance[it.v] = distance[node.v] + it.w;
                    pq.add(new Node(it.v, distance[it.v]));
                }
            }
        }
        return distance;
    }
}
