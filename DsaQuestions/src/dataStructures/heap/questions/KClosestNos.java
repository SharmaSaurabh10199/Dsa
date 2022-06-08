package dataStructures.heap.questions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
// this is very very important concept
public class KClosestNos {
    class pair{
        int key;
        int value;
        public pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    class pairComparator implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            return o2.key-o1.key;
        }
    }
    public  void closestKnos(int[] arr, int k, int x){
        PriorityQueue<pair> pq= new PriorityQueue<pair>(new pairComparator() );
        for (int i = 0; i < arr.length; i++) {
            pq.add(new pair(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        while (!pq.isEmpty()){
            System.out.println(pq.poll().value+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr={10, 2, 14, 4, 7, 6};
        KClosestNos k= new KClosestNos();
        k.closestKnos(arr,3,5);
    }
}
