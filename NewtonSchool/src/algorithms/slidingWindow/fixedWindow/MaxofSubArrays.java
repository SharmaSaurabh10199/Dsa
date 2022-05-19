package algorithms.slidingWindow.fixedWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K
 */
public class MaxofSubArrays {
    static void maxInEachWindow(int[] arr, int k){
        int i=0,j=0;
        Deque<Integer> dq= new ArrayDeque<>();
        while (j<arr.length){
            while (!dq.isEmpty() && arr[j]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                System.out.print(dq.peekFirst()+" ");
                if(arr[i]==dq.peekFirst()){
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr={1,2,3,1,4,5,2,3,6};
//        maxInEachWindow(arr,3);
    }
}
