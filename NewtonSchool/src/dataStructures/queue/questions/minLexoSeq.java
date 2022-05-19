package dataStructures.queue.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
Smallest Lexicographic Subsequence of size k in an Array:
Given an array Arr of size N and an integer K.
 Todo wants you to find lexicographically minimum subsequence of the array of size K.

 EX: Array : [3,1,5,3,5,9,2] k =4
Expected Soultion : 1 3 5 2
 */
public class minLexoSeq {
    // using deque data structure.
    public static void minLexoSeq(int[] arr, int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[i] < dq.peekLast() && dq.size() + n - 1 - i >= k) {
                dq.removeLast();
            }
            if (dq.size() < k) {
                dq.add(arr[i]);
            }
        }
        //System.out.println(dq);
        for (Integer i : dq) {
            System.out.println(i + " ");
        }
    }

    // using stack data structure:
    public static void minLexiSeq(int[] arr, int n, int k) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < st.peek() && st.size() + n - 1 - i >= k) {
                st.pop();
            }
            if (st.size() < k) {
                st.push(arr[i]);
            }

            //        while (!st.isEmpty()){
//            aux.push(st.pop());
//        }
            //System.out.println(st);
            while (!aux.isEmpty()){
                System.out.println(aux.pop()+" ");
            }

        }

    }
    public static void main(String[] args) {
        int[] arr={12,2,1,3,4};
        minLexiSeq(arr,arr.length,4);

    }
}
