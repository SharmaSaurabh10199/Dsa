package dataStructures.heap.questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
    public static int kthLargest(int[] arr, int k){
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public static int rough(int[] arr, int k){
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr={7,3,4,10,8,5};
        System.out.println(kthLargest(arr,3));
    }
}
