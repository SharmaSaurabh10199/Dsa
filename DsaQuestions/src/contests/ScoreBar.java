package contests;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ScoreBar {
    public static void nextgreater(int[] arr, int n){
        Stack<Integer> st= new Stack<>();
       // ArrayList<Integer> list= new ArrayList<>();
        int[] res= new int[n];
        for (int i = n-1; i >=0; i--) {
            // for next smaller, we'll apply the condition as st.peek()>arr[i]. somes goes in while loop
            if(!st.isEmpty()&& st.peek()<=arr[i]){
                while (!st.isEmpty()&& st.peek()<=arr[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else {
               //list.add(st.peek());
                res[i]=st.peek();
            }
            st.push(arr[i]);
        }
        int max=-1;

        for (int i = 0; i < n; i++) {
            if(res[i]!=-1){
                max=Math.max(res[i]-arr[i],max);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        //int[] arr={7,10,7,2,1,8};
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        nextgreater(arr,arr.length);
    }
}
