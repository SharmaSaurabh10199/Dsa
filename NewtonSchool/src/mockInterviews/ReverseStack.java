package mockInterviews;

import java.util.Stack;

public class ReverseStack {
    //static Stack<Integer> st= new Stack<>();
    public static void reverse(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int element= st.pop();
        reverse(st);
        insertBottom(st,element);
    }
    public static void insertBottom(Stack<Integer> st, int ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        int top=st.pop();
        insertBottom(st,ele);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }
}
