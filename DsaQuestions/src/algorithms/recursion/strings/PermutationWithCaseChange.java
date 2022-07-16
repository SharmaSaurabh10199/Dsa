package algorithms.recursion.strings;

import java.util.ArrayList;
import java.util.List;

/*
Print all permutations of a string keeping the sequence but changing cases.
Input : ab
Output : AB Ab ab aB

Input : ABC
Output : abc Abc aBc ABc abC AbC aBC ABC
 */
public class PermutationWithCaseChange {
    public static void caseChange(String op, String ip){
        if(ip.length()==0){
            System.out.print(op+" ");
            return;
        }
        char ch=ip.charAt(0);
        String op1="",op2="";
        if(ch>='a' && ch<='z'){
            op1= op+ch;
            char ch2= (char) (ch-'a'+'A');
            op2=op+ch2;
        }
        else if(ch>='A' && ch<='Z'){
            op1= op+ch;
            char ch2= (char) (ch-'A'+'a');
             op2=op+ch2;
        }
        String newIp= ip.substring(1);
        caseChange(op2,newIp);
        caseChange(op1,newIp);

    }

    public static void main(String[] args) {
        caseChange("","ABC");
        // abc Abc aBc ABc abC AbC aBC ABC
    }

}
/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.



Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 */
// # accepted on leetcode:
class letterWithNumber{
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> list= new ArrayList<>();
        result(list,"",s);
        return list;

    }
    public void result(ArrayList<String> list, String op, String ip){
        if(ip.length()==0){
            list.add(op);
            return;
        }
        char ch=ip.charAt(0);
        if(ch>='0' && ch<='9'){
            String op1=op+ch;
            String newIp=ip.substring(1);
            result(list,op1,newIp);
        }
        else {
            String op1="",op2="";
            if(ch>='a' && ch<='z'){
                op1= op+ch;
                char ch2= (char) (ch-'a'+'A');
                op2=op+ch2;
            }
            else if(ch>='A' && ch<='Z'){
                op1= op+ch;
                char ch2= (char) (ch-'A'+'a');
                op2=op+ch2;
            }
            String newIp= ip.substring(1);
            result(list,op2,newIp);
            result(list,op1,newIp);
        }
    }
}
