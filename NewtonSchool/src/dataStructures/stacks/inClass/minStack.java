package dataStructures.stacks.inClass;

import java.util.Stack;

public class minStack {
    static Stack<Integer> s= new Stack<>();
    static Stack<Integer> ss= new Stack<>();
    public int min(){
        if(ss.isEmpty()){
           // System.out.println(-1);
            return -1;
        }
        return ss.peek();
    }
    public void push(int val){
        s.push(val);
        if(ss.isEmpty() || s.peek()<=ss.peek()){
            ss.push(val);
        }
    }
    public int pop(){
        if(s.isEmpty()){
            return -1;
        }
        int ans=s.peek();
        s.pop();
        if(ans==ss.peek()){
            ss.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
//        minStack m= new minStack();
//        System.out.println(m.min());
//        m.push(18);
//        m.push(19);
//        m.push(15);
//        m.push(15);
//        m.push(16);
//        m.pop();
//        m.pop();
//
//        System.out.println(m.min());
//        m.pop();
//        System.out.println(m.min());
//        m.pop();
//        System.out.println(m.min());
        MinInConstAuxSpace m= new MinInConstAuxSpace();
        System.out.println(m.getMin());;
        m.push(5);
        m.push(3);
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());
    }
}
class MinInConstAuxSpace{
    static int minElement;
    static Stack<Integer> st;
    public MinInConstAuxSpace(){
        st= new Stack<>();
    }
    public int getMin(){
        if(st.isEmpty()){
            return -1;
        }
        return minElement;
    }
    public void push(int val){
        if(st.isEmpty()){
            st.push(val);
            minElement=val;
        }
        else {
            if(val>=minElement){
                st.push(val);
            }
            // this works as a flag
            else {
                st.push(2*val-minElement);
                minElement=val;
            }
        }
    }
    public void pop(){
        if(st.isEmpty()){
            return ;
        }
        else {
            if(st.peek()>=minElement){
                st.pop();
            }
            else {
                minElement=2*minElement-st.peek();
                st.pop();
            }
        }
    }
    public int top(){
        if(st.isEmpty()){
            return -1;
        }
        else {
            if(st.peek()>=minElement){
                return st.peek();
            }
            else {
                return minElement;
            }
        }
    }
}
