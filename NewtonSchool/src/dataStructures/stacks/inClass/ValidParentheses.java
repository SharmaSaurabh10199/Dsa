package dataStructures.stacks.inClass;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String str){
        Stack<Character> st= new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch= str.charAt(i);
            if(ch=='('||ch=='{'|| ch=='['){
                st.push(ch);
            }
            else if(ch==')'||ch=='}'|| ch==']'){
                if(st.isEmpty()){
                    return false;
                }
                char comp=st.pop();
                if((ch==')'&&comp!='(') || (ch=='}'&&comp!='{')||(ch==']'&&comp!='[')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
