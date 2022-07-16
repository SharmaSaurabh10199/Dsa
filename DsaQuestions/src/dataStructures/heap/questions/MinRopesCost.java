package dataStructures.heap.questions;

import java.util.PriorityQueue;

public class MinRopesCost {
    public int minCost(int[] arr){
        int cost=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (pq.size()>2){
            int first=pq.poll();
            int second=pq.poll();
            cost+=first+second;
            pq.add(first+second);
        }
        return cost;
    }

}
