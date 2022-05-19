package dataStructures.stacks;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        String str="";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String str){
        Stack<Character> st= new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if(c=='{'|| c=='['|| c=='('){
                st.push(c);
            }
            else if(c==')'|| c==']'|| c=='}'){
                if(st.isEmpty()){
                    return false;
                }
                if(!isComplimentry(st.pop(),c)){
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
    public static boolean isComplimentry(char a, char b ){
        if(a=='(' && b==')'){
            return true;
        }
        else if(a=='{'&& b=='}'){
            return true;
        }
        else if(a=='['&& b==']' ){
            return true;
        }
        return false;
    }
}
