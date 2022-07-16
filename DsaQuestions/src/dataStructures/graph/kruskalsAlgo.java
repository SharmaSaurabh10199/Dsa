package dataStructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class kruskalsAlgo {
    int[] parent;
    int[] rank;
    static class tuple{
        int u;
        int v;
        int weight;
        public tuple(int u, int v, int weight){
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
    }
    class tupleSort implements Comparator<tuple>{
        @Override
        public int compare(tuple o1, tuple o2) {
            return o1.weight-o2.weight;
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
    void kruskals (ArrayList<tuple> list, int n){
        parent= new int[n+1];
        rank= new int[n+1];
        ArrayList<tuple> mst= new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            parent[i]=i;
        }
        int minCost=0;
        Collections.sort(list,new tupleSort());
        for(tuple it: list){
            if(parent[it.u]!=parent[it.v]){
                mst.add(it);
                minCost+=it.weight;
                union(it.u,it.v);
            }
        }
        System.out.println(minCost);
        for(tuple itr: mst){
            System.out.println(itr.u+" "+itr.v+" "+itr.weight);
        }
    }

    public static void main(String[] args) {
        kruskalsAlgo obj= new kruskalsAlgo();
        ArrayList<tuple> ls= new ArrayList<>();
        ls.add(new tuple(1,2,2));
        ls.add(new tuple(2,6,7));
        ls.add(new tuple(6,3,8));
        ls.add(new tuple(3,4,5));
        ls.add(new tuple(4,5,9));
        ls.add(new tuple(5,1,4));
        ls.add(new tuple(4,1,1));
        ls.add(new tuple(4,2,3));
        ls.add(new tuple(3,2,3));
        obj.kruskals(ls, ls.size());

    }
}
