package assignments.feb15Strings;

import java.util.Scanner;

public class Ques3 {
    public static void main(String[] args) {
//        String s= "bbbaa";
//        res(s);
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        String s1= s.next();
        res(s1);
    }
    public static void res(String s){
        int count1=0,count2=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a'){
                count1++;
            }
            else{
                count2++;
            }
        }
        System.out.println(Math.min(count1,count2));
    }
}
