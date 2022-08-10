package dataStructures.graph;

import java.util.Comparator;
import java.util.*;

public class PrimsAlgo {
    class Node {
        int u;
        int w;

        public Node(int u, int w) {
            this.u = u;
            this.w = w;
        }
    }

    // implement the comparator
    class Compare implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            if (node1.w < node2.w)
                return -1;
            if (node1.w > node2.w)
                return 1;
            return 0;
        }

    }

    public void primsAlgo(ArrayList<ArrayList<Node>> graph, int v) {
        int key[] = new int[v];
        boolean mst[] = new boolean[v];
        int parent[] = new int[v];

        // fill the arrays with initial values
        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }
        key[0] = 0;

        // make a pq to remove the minimum edge everytime
        // Pri<Node> pq = new PriorityQueue<Node>(new Compare());
        PriorityQueue<Node> pq = new PriorityQueue(new Compare());
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            // take the minimum edge out of the given
            Node node = pq.poll();
            int u = node.u;
            mst[u] = true;
            // update the keys and the parent
            for (Node it : graph.get(u)) {
                if (mst[it.u] == false && it.w < key[it.u]) {
                    parent[it.u] = u;
                    key[it.u] = it.w;
                    pq.add(new Node(it.u, key[it.w]));
                }
            }
        }
        // printing the result
        for (int i = 1; i < v; i++) {
            System.out.println(parent[i] + "-" + i);
        }

    }

}
