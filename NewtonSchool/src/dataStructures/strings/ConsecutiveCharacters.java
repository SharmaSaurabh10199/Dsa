package dataStructures.strings;
/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.



Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String s="abbcccddddeeeeedcba";
        System.out.println(powerOfString(s));
    }
    public static int powerOfString(String s){
        int i=1,max=1,pow=1;
        while (i<s.length()){
            if(s.charAt(i)==s.charAt(i-1)){
                pow++;
                if(max<pow){
                    max=pow;
                }
            }
            else {
                pow=1;
            }
            i++;
        }
        return max;
    }
}
