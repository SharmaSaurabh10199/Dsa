package dataStructures.heap.questions;

import java.util.*;

/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task
 or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> hm= new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> item: hm.entrySet()){
            pq.add(item.getValue());
        }
        int cycle=0;
        while (!pq.isEmpty()){
            ArrayList<Integer> list= new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                if(!pq.isEmpty()){
                    // pop out the tasks
                    list.add(pq.poll());
                }
            }
            for(int i: list){
                if(--i>0){
                    // push back if its still unfinished
                    pq.add(i);
                }
            }
            // if its not the last cycle, time will be n+1(idle time has to be counted here), for cycle it will be just
            // the list size as idle time after these times will not be counted.
            cycle+= pq.isEmpty()? list.size():n+1;
        }
        return cycle;
    }
}
