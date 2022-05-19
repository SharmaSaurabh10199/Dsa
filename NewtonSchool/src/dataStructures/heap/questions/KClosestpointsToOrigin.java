package dataStructures.heap.questions;
/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that
 it is in).

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestpointsToOrigin {
    class pair{
        int x;
        int y;
        public pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    class pairSort implements Comparator<pair>{
        @Override
        public int compare(pair o1, pair o2) {
            // avoid using sqrt function.
            int distance1=  (o1.x*o1.x+o1.y*o1.y);
            int distance2= (o2.x*o2.x+o2.y*o2.y);
            return (distance2-distance1);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int res[][] = new int[k][2];
        PriorityQueue<pair> pq= new PriorityQueue<>(new pairSort());
        for (int i = 0; i < points.length; i++) {
            pq.add(new pair(points[i][0],points[i][1]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i][0]=pq.peek().x;
            res[i][1]=pq.peek().y;
            pq.poll();
        }
        return res;
    }
}
