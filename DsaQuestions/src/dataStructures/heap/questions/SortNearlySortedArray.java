package dataStructures.heap.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts
 in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at
 indexes 5, 6, 7, 8, 9 in the given array.
 */
public class SortNearlySortedArray {
    public static void sortNearlySorted(int[] arr, int k){
        PriorityQueue<Integer > pq= new PriorityQueue<>();
        ArrayList<Integer> list= new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size()>k){
                list.add(pq.poll());
            }
        }
        while (!pq.isEmpty()){
            list.add(pq.poll());
        }
        System.out.println(list);

    }

    public static void main(String[] args) {
        int[] arr={7,6,2,3,3};
        sortNearlySorted(arr,3);
    }
}
