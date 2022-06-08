package algorithms.recursion.stack;

import java.util.Stack;

public class deleteMiddle {
    public static void deleteMiddle(Stack<Integer> st, int k){
        if(k==0){
            st.pop();
            return;
        }
        int top=st.pop();
        deleteMiddle(st, k-1);
        st.push(top);

    }

    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(-13);
        st.push(10);
        st.push(-9);
        //st.push(90);
        st.push(12);
        int middle=st.size()/2;
        deleteMiddle(st,middle);
        System.out.println(st);
    }
}
