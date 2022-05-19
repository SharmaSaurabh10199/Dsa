package contests;

import java.util.Scanner;

public class bulidings {
    public static int countVisible(long[] arr, int n){
        long max=arr[0];
        int count=1;
        for (int i = 1; i < n; i++) {
            if(max<arr[i]){
                max=arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        long[] arr= new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextLong();
        }
        System.out.println(countVisible(arr,arr.length));;
    }
}
