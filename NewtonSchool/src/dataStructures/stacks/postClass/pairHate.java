package dataStructures.stacks.postClass;

import java.util.Stack;

/*
Given a string S you have to remove all pairs of identical letters, which are consecutive.
 If after the removal there appear new pairs, remove them as well. Repeat this untill no
 adjacent letter in the string is same.
Note that deleting of the consecutive identical letters can be done in any order
, as any order leads to the same result.

Sample Input
hhoowaaaareyyoouu

Sample Output
wre
 */
public class pairHate {
    static String res="";
    static boolean flag=true;
    public static void modify(String str){
         res="";
        Stack<Character> st= new Stack<>();
        Stack<Character> auxSt=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(st.isEmpty()){
                st.push(str.charAt(i));
                continue;
            }
            else if(str.charAt(i)==st.peek()){
                flag=false;
                st.pop();
                i++;
            }
            if(i<str.length()){
                st.push(str.charAt(i));
            }
        }
        if(st.isEmpty()){
            System.out.println("");
        }
        else {
            while (!st.isEmpty()){
                auxSt.push(st.pop());
            }
            while (!auxSt.isEmpty()){
                //System.out.print(auxSt.pop()+"");
                res+=auxSt.pop();
            }
        }


    }


    public static void main(String[] args) {
       // modify("hhoowaaaareyyoouu");
        String str="abcddcb";
        modify(str);
        while (flag==false){
            flag=true;
            modify(res);
        }
        System.out.println(res);
    }
}
