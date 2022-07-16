package dataStructures.stacks.inClass;

import java.util.ArrayList;
import java.util.Stack;

public class greaterToLeft {
    public static void nextgreater(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // for next smaller, we'll apply the condition as st.peek()>=arr[i]. somes goes in while loop
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                list.add(-1);
            } else {
                list.add(st.peek());
            }
            st.push(arr[i]);
        }
//        for(int i= list.size()-1;i>=0;i--){
//            System.out.print(list.get(i)+" ");
//        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 6, 7, 8};
        nextgreater(arr, arr.length);
//        Scanner s= new Scanner(System.in);
//        int n= s.nextInt();
//        int[] arr= new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]=s.nextInt();
//        }
//        nextgreater(arr,arr.length);
    }
}
