package algorithms.recursion.stack;

import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int top=st.pop();
        sortStack(st);
        insert(st,top);
    }
    public static void insert(Stack<Integer> st, int element){
        if(st.isEmpty() || st.peek()<=element){
            st.push(element);
            return;
        }
        int top=st.pop();
        insert(st,element);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(-13);
        st.push(10);
        st.push(-9);
        st.push(90);
        sortStack(st);
        System.out.println(st);
    }
}
