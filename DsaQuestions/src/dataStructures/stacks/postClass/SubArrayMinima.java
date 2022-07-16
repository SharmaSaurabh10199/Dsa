package dataStructures.stacks.postClass;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Statement
You are given an array(Arr) of N Distinct integers. You have to find the sum of minimum element of all the subarrays
 (continous) in that array. See Sample for better understanding.

 Sample Input
3
1 2 3

Sample Output
10

Explaination
all subarrays [1] [1,2] [1,2,3] [2] [2,3] [3]
 */
public class SubArrayMinima {
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
        //result(arr,arr.length);
//        Scanner s= new Scanner(System.in);
//        int n= s.nextInt();
//        long[] arr= new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]=s.nextLong();
//        }
         result(arr,arr.length);
    }
    public static void result(int[] arr, int n){
        int[] leftSmaller= new int[n];
        int[] rightSmaller= new int[n];
        leftSmaller(arr,leftSmaller,n);
        rightSmaller(arr, rightSmaller,n);
        int res=0;
        for (int i = 0; i < n; i++) {
            res+=(leftSmaller[i]+1)*(rightSmaller[i]+1)*arr[i];
        }
        System.out.println(res);
    }
    public static void leftSmaller(int[] arr, int[] leftSmaller, int n){
        Stack<Integer> st= new Stack<>();
        for (int i = 0; i < n; i++) {
            if(!st.isEmpty()&& arr[st.peek()]>=arr[i]){
                while (!st.isEmpty()&& (arr[st.peek()] >= arr[i])){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                leftSmaller[i]=i;
            }
            else {
                leftSmaller[i]=i-st.peek()-1;
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(leftSmaller));
    }
    public static void rightSmaller(int[] arr, int[] rightSmaller, int n){
        Stack<Integer> st= new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            if(!st.isEmpty()&& arr[st.peek()]>=arr[i]){
                while (!st.isEmpty()&& (arr[st.peek()] >= arr[i])){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                rightSmaller[i]=n-i-1;
            }
            else {
                rightSmaller[i]=st.peek()-i-1;
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(rightSmaller));
    }
}
