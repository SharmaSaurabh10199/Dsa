package contests;

import java.util.Scanner;

public class firstDay {
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        String str= s.next();
//        if(str.equals("Apple")){
//            System.out.println("Gravity");
//        }
//        else {
//            System.out.println("Space");
//        }
        winner(str);
    }
    public static void winner(String str){
        int c1=0;
        int c2=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='N'){
                c1++;
            }
            else {
                c2++;
            }
        }
        if(c1>c2){
            System.out.println("Nutan");
        }
        else {
            System.out.println("Tusla");
        }
    }
}
