package contests;

import java.util.Arrays;
import java.util.Scanner;

public class loneSum {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        result(arr,arr.length);
    }
    static void result(int[] arr, int n){

        int[] res= new int[10];
        for (int i = 0; i < n; i++) {
            int result=findlowestNum(arr[i]);
            res[result]+=1;
        }
        for (int i = 1; i < 9; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println(res[9]);
    }
    static int findlowestNum(int num){
        if(num%10==0){
            return num;
        }
        num=findDigitSum(num);
        return findlowestNum(num);

    }
    static int findDigitSum(int num){
        int res=0;
        while (num!=0){
            int rem=num%10;
            res+=rem;
            num=num/10;
        }
        return res;
    }
}
