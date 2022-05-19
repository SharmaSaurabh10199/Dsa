package dataStructures.stacks.postClass;

import java.util.HashMap;
import java.util.Stack;

/*
Given an array of N elements, for each element find the value of nearest element to the right which is
having frequency greater than as that of current element.
 If there does not exist an answer for a position, then make the value ‘-1’.
 Sample Input:-
6
1 2 1 3 2 1

Sample Output:-
-1 1 -1 2 1 -1

 */
public class NextLargerFreq {
    public static void nextGreaterFreq(int[] arr, int n){
        HashMap<Integer,Integer> hm= new HashMap<>();
        Stack<Integer > st= new Stack<>();
        int[] res= new int[n];
        for (int i = 0; i < n; i++) {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for (int i = n-1; i >=0; i--) {
            while (!st.isEmpty() && hm.get(arr[i])>=hm.get(st.peek())){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else {
                res[i]=st.peek();
            }
            st.push(arr[i]);
        }
       // System.out.println(Arrays.toString(res));
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,1,3,2,1};
        nextGreaterFreq(arr,arr.length);
    }
}
