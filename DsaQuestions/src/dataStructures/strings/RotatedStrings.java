package dataStructures.strings;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
/*
  approaches1:
     steps: 1) find all the indexes of first characters of str1 in str2, now for every index found, check
            2) check if any of the index found matches the str1
            this approach is not good, worst time can go upto o(n2);
  approach2:
    steps: 1) push both the strings in 2 queues,
           2) pop front of q2 and push back max untill the size
           3) if anytime q2 equals to q1, return true.

   approach:
     steps:1) create a temp string as str1+str1
           2) check of str2 is present in temp


 */
public class RotatedStrings {
    // approach 2
    static public boolean isRotated(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        Queue<Character> q1= new LinkedList<>();
        Queue<Character> q2= new LinkedList<>();
        for (int i = 0; i < str2.length(); i++) {
            q1.add(str1.charAt(i));
            q2.add(str2.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch= q2.peek();
            q2.poll();
            q2.add(ch);
            if(q1.equals(q2)){
                return true;
            }
        }
        return false;
    }
    // approach 3, tricky one
    static boolean isRotatedOptimized(String str1,String str2){
        String temp= str1+str1;
        return temp.indexOf(str2)!=-1;
    }

    public static void main(String[] args) {
        System.out.println(isRotatedOptimized("abcd","cdab"));
    }

}
