package basicMathematics.PrimeNos;

import java.util.Scanner;

/*
Given two integers ‘a’ and ‘m’. The task is to find modular multiplicative inverse of ‘a’ under modulo ‘m’.
Note: Print the smallest modular multiplicative inverse.
Input
First line of input contains a single integer T denoting number of test cases, next T lines contains two space separated integers depicting value of a and m.

Constraints :-
1 < = T < = 100
1 < = m < = 100
1 < = a < = m

 */
public class MultiplicativeModulo {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t= s.nextInt();
        for(int k=0; k<t; k++){
            boolean flag= false;
            int a= s.nextInt();
            int m= s.nextInt();
            if(a==1){
                System.out.println(m+1);
            }
            else{
                for(int i=1; i<=m ; i++){
                    if((a*i)%m==1){
                        flag=true;
                        System.out.println(i);
                    }
                }
                if(flag==false){
                    System.out.println(-1);
                }
            }
        }
    }
}
