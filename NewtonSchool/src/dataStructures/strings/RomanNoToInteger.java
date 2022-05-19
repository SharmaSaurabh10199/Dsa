package dataStructures.strings;
/*
Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
 */
public class RomanNoToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("CMXVI"));
    }
    public static int romanToInt(String s){
        int result=value(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >=0; i--) {
           if(value(s.charAt(i))<value(s.charAt(i+1))){
               result=result-value(s.charAt(i));
           }
           else {
               result+=value(s.charAt(i));
           }
        }
        return result;
    }
    public static int value(char ch){
        int val=0;
        switch (ch){
            case 'I': val=1;
                break;
            case 'V': val=5;
                break;
            case 'X': val=10;
                break;
            case 'L': val=50;
                break;
            case 'C': val=100;
                break;
            case 'D': val=500;
                break;
            case 'M': val=1000;
                break;
            default: val=0;
        }
        return val;
    }
}
