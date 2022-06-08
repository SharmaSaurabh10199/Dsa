package dataStructures.stacks.postClass;

import java.util.Scanner;
import java.util.Stack;

/*
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:

Input:
N = 7
arr[] = {10,20,30,50,10,70,30}
Output: 70 30 20 10 10 10 10
 */
public class maxOfMinOfEachWind {

    public static void result(int[] arr, int n){
        int[] leftSmaller= new int[n];
        int[] res= new int[n+1];
        int[] re1= new int[n];
        int[] rightSmaller= new int[n];
        leftSmaller(arr,leftSmaller,n);
        rightSmaller(arr,rightSmaller,n);
        for (int i = 0; i < n; i++) {
            int len=rightSmaller[i]-leftSmaller[i]-1;
            res[len]=Math.max(res[len],arr[i]);
        }
        for(int i=n-1; i>=1 ;i--){
            res[i]=Math.max(res[i],res[i+1]);
        }
        for (int i = 0; i < n+1; i++) {
            System.out.print(res[i]+" ");
        }
//        for (int i = 0; i < n; i++) {
//            re1[i]=res[i+1];
//        }
//        return re1;
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
                leftSmaller[i]=-1;
            }
            else {
                leftSmaller[i]=st.peek();
            }
            st.push(i);
        }
        //System.out.println(Arrays.toString(leftSmaller));
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
                rightSmaller[i]=n;
            }
            else {
                rightSmaller[i]=st.peek();
            }
            st.push(i);
        }
        //System.out.println(Arrays.toString(rightSmaller));
    }
    public static void main (String[] args) {
        // Your code here
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        result(arr,n);
    }

}
