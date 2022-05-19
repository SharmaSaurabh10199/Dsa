package dataStructures.heap.questions;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer
in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class TopKFreqElements {
    static class pair{
        int key;
        int value;
        public pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    static class pairSort implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            return o1.value-o2.value;
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res= new int[k];
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<pair> pq= new PriorityQueue<>(new pairSort());
        for (Map.Entry<Integer,Integer>item:
             hm.entrySet()) {
            pq.add(new pair(item.getKey(), item.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int j=0;
        while (!pq.isEmpty()){
            res[j++]=pq.poll().value;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr,2)));
    }
}
