package algorithms.recursion.strings;

import java.util.ArrayList;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 */
public class
generateBalancedParanthesis {
    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String > list= new ArrayList<>();
        int open=A;
        int close=A;
        String op="";
        result(list,open,close,op);
        return list;
    }
    public static  void result(ArrayList<String > list, int open, int close, String op){
        if(open==0 && close==0){
            list.add(op);
            return;
        }
        if(open!=0){
            String op1=op+"(";
            result(list,open-1,close,op1);
        }
        if(close>open){
            String op2=op+")";
            result(list,open,close-1,op2);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
