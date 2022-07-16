package assignments.feb15Strings;

import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
//        char c='1';
//        System.out.println(c-'0');
     //   System.out.println(largeSum("190","123910"));
        Scanner s= new Scanner(System.in);
        String s1= s.next();
        String s2= s.next();
        System.out.println(largeSum(s1,s2));
    }
    public static String largeSum(String str1, String str2){
        int len1= str1.length();
        int len2= str2.length();
        int carry=0;
        StringBuilder res= new StringBuilder();
        while(len1>0 || len2>0){
            int n1=0;
            int n2= 0;
            if(len1>0){
                n1=str1.charAt(len1-1)-'0';
            }
            if(len2>0){
                n2= str2.charAt(len2-1)-'0';
            }
            len1--;
            len2--;
            int sum= n1+n2+carry;
            int unit = sum%10;
            carry=sum/10;
            res.append((char)(unit+'0'));
        }
        if(carry>0){
            res.append((char)(carry+'0'));
        }
        String newStr= res.reverse().toString();
        return newStr;
    }
}
