package dataStructures.heap.questions.randompractise;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 */
public class MinStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size()>1){
            int y= pq.poll();
            int x= pq.poll();
            if(y>x){
                pq.add(y-x);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();

    }

}
