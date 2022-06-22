package dataStructures.graph;

public class DisjointSets {
    int[] rank;
    int[] parent;
    public DisjointSets(int v){
        parent= new int[v+1];
        rank= new int[v+1];
        for (int i = 1; i <=v ; i++) {
            parent[i]=i;
        }
    }

    int findParent(int u){
        if(parent[u]==u){
            return u;
        }
        return parent[u]=findParent(parent[u]);
    }
    void union(int u, int v){
        u=findParent(u);
        v=findParent(v);
        if(rank[u]==rank[v]){
            parent[u]=v;
            rank[v]++;
        }
        else if(rank[u]<rank[v]){
            parent[u]=v;
        }
        else {
            parent[v]=u;
        }
    }

    public static void main(String[] args) {
        int nodes=90;
        DisjointSets obj= new DisjointSets(nodes);


    }
}
