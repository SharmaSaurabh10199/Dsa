package dataStructures.stacks.inClass;

import java.util.ArrayList;
import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need
 to calculate the span of stocks price for all n days. The span Si of the stocks price on a given day i is defined as
 the maximum number of consecutive days just before the given day, for which the price of the stock on the current day
 is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
 corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Example 1:

Input:
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
 */
public class stockSpanProblem {
    public static void stockSpan(int[] arr, int n){
        Stack<Integer> st= new Stack<>();
        ArrayList<Integer> list= new ArrayList<>();
        for (int i =0;i<n;i++) {
            // for next smaller, we'll apply the condition as st.peek()>arr[i]. somes goes in while loop
            if(!st.isEmpty()&& arr[st.peek()]<=arr[i]){
                while (!st.isEmpty()&& arr[st.peek()]<=arr[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                list.add(-1);
            }
            else {
                list.add(st.peek());
            }
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i-list.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr={100,80,60,70,60,75,85};
        stockSpan(arr,arr.length);
    }
}

