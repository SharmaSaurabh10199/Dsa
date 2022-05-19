package contests;

import java.util.Arrays;
import java.util.Scanner;

public class maxForce {
    public static void maxForce(long[] arr, int n, int k){
        long maxForce=0;
        for (int i = 0; i < n; i++) {
            arr[i]=Math.abs(arr[i]);
        }
        Arrays.sort(arr);
        int i=n-1;
        int count=0;
        while (i>=0 && count<k){
            maxForce+=arr[i]*arr[i];
            count++;
            i--;
        }
        System.out.println(maxForce);
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int k=s.nextInt();
        long[] arr= new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextLong();
        }
        maxForce(arr,n,k);

    }
}
