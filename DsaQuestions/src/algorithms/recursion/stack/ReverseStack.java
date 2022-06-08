package algorithms.recursion.stack;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int top=st.pop();
        reverseStack(st);
        insertBottom(st,top);
    }
    public static void insertBottom(Stack<Integer> st,int element){
        if(st.isEmpty()){
            st.push(element);
            return;
        }
        int top=st.pop();
        insertBottom(st,element);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(-13);
        st.push(10);
        st.push(-9);
        st.push(90);
        reverseStack(st);
        System.out.println(st);
    }
}
