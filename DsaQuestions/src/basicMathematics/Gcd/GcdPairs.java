package basicMathematics.Gcd;
/*
First line of input contains a single integer N.
Second line of input contains N space separated integers, denoting array Arr.

Constraints:
2 <= N <= 100000
1 <= Arr[i] <= 100000
Output
Print the maximum value of GCD(Arr[i], Arr[j]) where i != j.
 */

import java.util.Scanner;

public class GcdPairs {
    // unoptimized approach
    public static void main(String[] args) {

            Scanner s= new Scanner(System.in);
            int t= s.nextInt();
            int[] arr= new int[t];
            for(int k=0; k<t; k++){
                arr[k]=s.nextInt();
            }
//            int max=0;
//            for(int i=0; i<arr.length-1; i++){
//                for(int j=i+1; j<arr.length; j++){
//                    if(max<gcd(arr[i],arr[j])){
//                        max=gcd(arr[i],arr[j]);
//                    }
//                }
//            }
//        System.out.println(max);
        System.out.println(res(arr,t));
    }
    public static int gcd(int x, int y){
        int a=Math.max(x,y);
        int b=Math.min(x,y);
        while (a%b!=0){
            int r= a%b;
            a=b;
            b=r;
        }
        return b;
    }
    // optimized approach
    public static int res(int[] arr, int t ){
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            max=Math.max(arr[i],max);
        }
        // store the factors in an array:
        int[] divisors= new int[max+1];
        for (int i = 0; i < t; i++) {
            for(int j=1; j<=Math.sqrt(arr[i]);j++){
                if(arr[i]%j==0){
                    divisors[j]++;
                    if(j!=arr[j]%j){
                        divisors[arr[i]/j]++;
                    }
                }
            }
        }
        for(int i=max; i>=1; i--){
         if(divisors[i]>1){
             return i;
         }
        }
        return 1;
    }
}
