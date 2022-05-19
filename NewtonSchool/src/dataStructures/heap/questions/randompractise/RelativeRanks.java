package dataStructures.heap.questions.randompractise;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.



Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] res= new String[score.length];
        HashMap<Integer,Integer> hm= new HashMap<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            hm.put(score[i],i);
            pq.add(score[i]);
        }
        int count=1;
        while (!pq.isEmpty()){
            int max=pq.poll();
            int idx=hm.get(max);
            if(count==1){
                res[idx]="Gold Medal";
            }
            else if(count==2){
                res[idx]="Silver Medal";
            }
            else if(count==3){
                res[idx]="Bronze Medal";
            }
            else {
                res[idx]=count+"";
            }
            count++;
        }
        return res;
    }
}
