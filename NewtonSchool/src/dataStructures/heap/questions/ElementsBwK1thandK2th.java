package dataStructures.heap.questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElementsBwK1thandK2th {
    public static long sumBetweenTwoKth(long arr[], long N, long K1, long K2)
    {
        PriorityQueue<Long> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if(maxHeap.size()>K2){
                maxHeap.poll();
            }
        }
        long second= maxHeap.peek();
        while (maxHeap.size()>K1){
            maxHeap.poll();
        }
        long first= maxHeap.peek();
        long res=0;
        for (int i = 0; i < N; i++) {
            if(arr[i]>first && arr[i]<second){
                res+=arr[i];
            }
        }
        return res;
    }
}
