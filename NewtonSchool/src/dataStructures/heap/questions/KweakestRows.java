package dataStructures.heap.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].
 */
public class KweakestRows {
    class pair{
        int[] arr;
        int row;
        public pair(int[] arr, int i){
            this.arr=arr;
            this.row=i;
        }
    }
    class pairSort implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            int soldiers1= countOnes(o1.arr);
            int soldiers2= countOnes(o2.arr);
            if(soldiers1==soldiers2){
                return o2.row-o1.row;
            }
            return soldiers2-soldiers1;
        }
    }
    public int countOnes(int[] arr){

        int low=0;
        int high= arr.length-1;
        if(arr[high]==1){
            return high+1;
        }
        while (low<=high){
            int mid= low+(high-low)/2;
            if(mid>0 && arr[mid]==0 && arr[mid-1]==1){
                return mid;
            }
            else if(arr[mid]==0){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return 0;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res= new int[k];
        PriorityQueue<pair> pq= new PriorityQueue<>(new pairSort());
        for (int i = 0; i < mat.length; i++) {
            pq.add(new pair(mat[i],i));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i=k-1;
        while (!pq.isEmpty()){
            res[i--]=pq.poll().row;
        }
        return res;

    }

    public static void main(String[] args) {
        KweakestRows obj= new KweakestRows();
        int[][] mat={{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] arr= obj.kWeakestRows(mat,3);
        System.out.println(Arrays.toString(arr));
    }

}
