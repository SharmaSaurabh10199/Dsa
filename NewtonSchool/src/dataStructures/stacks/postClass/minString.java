package dataStructures.stacks.postClass;

import java.util.Stack;

/*
Given a non-negative integer S represented as a string, remove K digits from the number so that the new number is the smallest possible.
Note : The given num does not contain any leading zero.

Example 1:

Input:
S = "149811", K = 3
Output: 111
Explanation: Remove the three digits
4, 9, and 8 to form the new number 111
which is smallest.
 */
public class minString {
    public static String minString(String str, int k){
        Stack<Character> st= new Stack<>();
        Stack<Character> aux= new Stack<>();
        StringBuilder sb= new StringBuilder("");
        //String res="";
        if(k>=str.length()){
            return sb.toString();
        }
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            if(st.isEmpty()|| c>=st.peek()){
                st.push(c);
            }
            else {
                while (k>0 && !st.isEmpty() && c<st.peek()  ){
                    st.pop();
                    k--;
                }
                st.push(c);
            }
        }
        if(k>0){
            while (k>0 && !st.isEmpty()){
                st.pop();
                k--;
            }
        }
        while (!st.isEmpty()){
            aux.push(st.pop());
        }
        while (!aux.isEmpty() && aux.peek()=='0'  ){
            aux.pop();
        }
        while (!aux.isEmpty()){
            sb.append(aux.pop());
        }
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="149811";
        System.out.println(minString(str,3));
    }
}
