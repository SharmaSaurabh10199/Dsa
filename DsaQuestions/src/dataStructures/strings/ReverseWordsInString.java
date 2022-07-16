package dataStructures.strings;

/*
Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

Example 1:

Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole
string(not individual words), the input
string becomes
much.very.program.this.like.i
 */
 /*
 String split function:
 s1.split("\\s")
 --> splits the string on the basis of white space:
  */
public class ReverseWordsInString {
    public static void main(String[] args) {
        String s="i.like.this.program.very.much";
        String s1="saurabh sharma";
       // String arr[]=s.split("\\.");
       // System.out.println(Arrays.toString(arr));
        System.out.println(reverse(s1));
    }
    public static String reverse(String s){
        StringBuilder res= new StringBuilder();
        String[] arr= s.split("\\. ");
        for(int i=arr.length-1; i>=0; i--){
            res.append(arr[i]);
            if(i!=0){
                res.append(".");
            }
        }
        return res.toString();
    }
}
