package algorithms.slidingWindow.fixedWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.



Example 1:

Input :

N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output :
-8 0 -6 -6
// this can be solved using queue
 */
public class FirstNegativeInSubArray {
    static void firstNegative(int[] arr, int k){
        int i=0,j=0;
        Deque<Integer> dq= new ArrayDeque<>();
        while (j<arr.length){
            if(arr[j]<0){
                dq.addLast(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(dq.isEmpty()){
                    System.out.println(0);
                }
                else {
                    System.out.println(dq.peekFirst());
                }

                if(arr[i]<0){
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={12,-1,-7,8,-16,30,16,28};
        firstNegative(arr,3);
    }
}
