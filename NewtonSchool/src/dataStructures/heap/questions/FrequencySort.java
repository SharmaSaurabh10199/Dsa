package dataStructures.heap.questions;

import java.net.Inet4Address;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency
of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 */
//# accepted on leetcode
public class FrequencySort {
    class freq{
        int key;
        int value;
        public freq(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    class freqComparator implements Comparator<freq>{

        @Override
        public int compare(freq o1, freq o2) {
            if(o1.value==o2.value){
                return o2.key-o1.key;
            }
            return o1.value-o2.value;
        }
    }
    public int[] frequencySort(int[] nums) {
        int[] res= new int[nums.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else {
                hm.put(nums[i],1);
            }
        }
        PriorityQueue<freq> pq= new PriorityQueue<>(new freqComparator());
        for (Map.Entry<Integer,Integer> item:
             hm.entrySet()) {
            pq.add(new freq(item.getKey(),item.getValue()));
        }
        int k=0;
        while (!pq.isEmpty()){
            int freq= pq.peek().value;
            int number= pq.peek().key;
            for (int i = 0; i < freq; i++) {
                res[k++]=number;
            }
            pq.poll();
        }
        return res;
    }
}
