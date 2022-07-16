package rough;

import dataStructures.graph.DijkstrasAlgo;

import java.util.*;

public class helper {
    static class Node {
        int v;
        int w;
        public Node (int v, int weight){
            this.v=v;
            this.w=weight;
        }
    }
    ArrayList<Node> adj[];
    public helper(int vertices){
        adj= new ArrayList[vertices+1];
        for (int i = 0; i < vertices+1 ; i++) {
            adj[i]= new ArrayList<>();
        }
    }
    int[] dijkstra(int V, int S) {
        // Write your code here
        // a minheap on the basis of the distance fro the source node
        PriorityQueue<Node> pq= new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w-o2.w;
            }
        });
        int[] distance= new int[V+1];
        // assume first that all nodes are at infinity distance
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Node(S,0));
        distance[S]=0;
        while(!pq.isEmpty()){
            Node node= pq.poll();
            for(Node it: adj[node.v]){
                // push in queue id the distance is smaller than the curr distance

                if(distance[node.v]+it.w<distance[it.v]){
                    distance[it.v]= distance[node.v]+it.w;
                    pq.add(new Node(it.v,distance[it.v]));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        helper h= new helper(n+1);
        int m= sc.nextInt();
        for (int i = 0; i < m; i++) {
             int source= sc.nextInt();
             int dest= sc.nextInt();
             int weight= (source+dest)%1000;
             h.adj[source].add(new Node(dest,weight));
             h.adj[dest].add(new Node(source,weight));
        }
        int[] res= h.dijkstra(n,1);
        for (int i = 2; i <=n ; i++) {
            if(res[i]!=Integer.MAX_VALUE){
                System.out.println(res[i]);
            }
            else {
                System.out.println(-1);
            }
        }

    }
}
