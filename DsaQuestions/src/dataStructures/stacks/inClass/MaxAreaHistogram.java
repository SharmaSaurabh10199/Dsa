package dataStructures.stacks.inClass;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaHistogram {
    public static void maxAreaHistogram(int[] arr, int n){
        int maxArea=0;
        int[] leftSmaller= new int[n];
        int[] rightSmaller= new int[n];
        leftSmaller(arr,leftSmaller,arr.length);
        rightSmaller(arr,rightSmaller,arr.length);
        for (int i = 0; i < n; i++) {
            int area=(rightSmaller[i]-leftSmaller[i]-1)*arr[i];
            maxArea=Math.max(area,maxArea);
        }
        System.out.println(maxArea);
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
                rightSmaller[i]=n;
            }
            else {
                rightSmaller[i]=st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(rightSmaller));
    }

    public static void main(String[] args) {
        int[] arr={6,2,5,4,5,1,6};
        maxAreaHistogram(arr,arr.length);
    }
}
