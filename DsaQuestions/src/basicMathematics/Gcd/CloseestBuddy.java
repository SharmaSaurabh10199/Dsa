package basicMathematics.Gcd;

import java.util.Scanner;

/*
You are given an integer array A of size N. For each index i (1 <= i <= N), you need to find an index j, such that gcd(A[i], A[j]) = 1, and abs(i-j) is the minimum possible. If there are two values of j satisfying the condition, report the minimum one. If there is no possible value of j, report -1.

Note: gcd(x, y) represents the the greatest common divisor of integers x and y, while abs(i- j) represents the absolute value of (i-j). Eg: gcd(6, 15) = 3 ; abs(6-15) = 9.

See sample for better understanding.
Input
The first line of the input contains a single integer N.
The next line of the input contains N space separated integers, the elements of the array A.

Constraints
1 <= N <= 200000
1 <= A[i] <= 50
Output
Output N space separated integers, the value of j corresponding to each index. If there is no possible value of j, report -1 instead.
 */
public class CloseestBuddy {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t= s.nextInt();
        int[] arr= new int[t+1];
        for(int k=1; k< arr.length; k++){
            arr[k]=s.nextInt();
        }

        for(int i=1; i< arr.length; i++){
            int res=-1;
            int min= Integer.MAX_VALUE;
            for(int j=1; j< arr.length; j++){

                if(gcd(arr[i],arr[j])==1){
                  if(min>Math.abs(i-j)){
                      min= Math.abs(i-j);
                      res=j;
                  }
                }
            }
            System.out.print(res+" ");
        }

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
}
