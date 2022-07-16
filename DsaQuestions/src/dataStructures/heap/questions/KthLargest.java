package dataStructures.heap.questions;

import java.util.PriorityQueue;

class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;
        pq=new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()==k){
            return pq.peek();
        }
        pq.poll();
        return pq.peek();
    }
}
