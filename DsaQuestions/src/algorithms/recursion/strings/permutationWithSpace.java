package algorithms.recursion.strings;

import java.util.ArrayList;

/*
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.
The output should be printed in sorted increasing order of strings

Example 1:

Input:
S = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation:
ABC
AB C
A BC
A B C
These are the possible combination of "ABC"
 */
public class permutationWithSpace {
    //static ArrayList<String> list= new ArrayList<>();
    public static ArrayList<String> permutation(String S){
        ArrayList<String> list= new ArrayList<>();
        // Code Here
        String op= ""+S.charAt(0);
        String ip= S.substring(1);
        perm(list,op,ip);
        return list;
    }
    public static void perm(ArrayList<String> list,String op, String ip){
        if(ip.length()==0){
            list.add(op);
            return;
        }
        String op1= op+ip.charAt(0);
        String op2= op+" "+ip.charAt(0);
        String newIp= ip.substring(1);
        perm(list,op1,newIp);
        perm(list,op2,newIp);
    }

    public static void main(String[] args) {
        permutation("LW");
       // System.out.println(list);
    }
}
