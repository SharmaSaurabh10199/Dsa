package dataStructures.stacks.postClass;

import java.util.Stack;

/*
There are N buildings in Linear Land. They appear in a linear line one after the other and their heights are given
in the array arr[]. Geek wants to select three buildings in Linear Land and remodel them as recreational spots.
The third of the selected building must be taller than the first and shorter than the second.
Can geek build the three-building recreational zone?


Example 1:

Input:
N = 6
arr[] = {4, 7, 11, 5, 13, 2}
Output:
True
 */
public class
Geeky132pattern {
    // with using stack
    public static boolean hasPattern(int[] arr, int n){
        int[] min = new int[n];
        min[0]=arr[0];
        Stack<Integer> st= new Stack<>();
        for (int i = 1; i < n; i++) {
            min[i]=Math.min(min[i-1],arr[i]);
        }
        for(int i=n-1; i>0; i--){
            if(st.isEmpty()){
                st.push(arr[i]);
            }
            while(!st.isEmpty() && st.peek()<=min[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()<arr[i] && arr[i]>min[i]){
                return true;
            }
            st.push(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={4,7,11,5,13,2};
        System.out.println(hasPattern(arr,arr.length));
    }
}
