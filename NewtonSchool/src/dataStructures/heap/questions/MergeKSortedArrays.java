package dataStructures.heap.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class pair{
        int arrayElement;
        int i;
        int j;
        public pair(int arrayElement, int i, int j){
            this.i = i;
            this.arrayElement=arrayElement;
            this.j=j;
        }
    }
    static class pairSort implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            return o1.arrayElement-o2.arrayElement;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        // Write your code here.
        ArrayList<Integer> res= new ArrayList<>();
        PriorityQueue<pair > pq= new PriorityQueue<>(new pairSort());

//        for (int i = 0; i < arr.length; i++) {
//            pq.add(new pair(arr[i][0],i,0));
//        }
        int i=0;
        while (i<arr.length){
            pq.add(new pair(arr[i][0],i,0));
            i++;
        }
        while (!pq.isEmpty()){
            pair p= pq.poll();
            res.add(p.arrayElement);
            p.j++;
            if(p.j<arr[p.i].length){
                pq.add(new pair(arr[p.i][p.j],p.i,p.j));
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        ArrayList list=mergeKArrays(arr,3);
        System.out.println(list);
    }
}
