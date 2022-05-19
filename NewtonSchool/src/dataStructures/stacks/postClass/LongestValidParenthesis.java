package dataStructures.stacks.postClass;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int logestValidParanthesis(String str){
        int max=0;
        Stack<Integer> st= new Stack<>();
        st.push(-1);
        for (int i = 0; i < str.length(); i++) {
            char ch= str.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else {
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else {
                    max=Math.max(i-st.peek(),max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(logestValidParanthesis(")()())"));
    }
}
