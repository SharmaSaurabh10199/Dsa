package assignments.Feb15;

import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t= s.nextInt();
        for(int k=0; k<t; k++) {
            int n= s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
          if(isSortedAndRotated(arr,arr.length)){
              System.out.println("Yes");
          }
          else {
              System.out.println("No");
          }
        }

    }
    public static boolean isSortedAndRotated(int[] arr,int n){
     int minIdx=0;
     int maxIdx=0;
        for (int i = 1; i <n ; i++) {
            if(arr[minIdx]>arr[i]){
                minIdx=i;
            }
            if(arr[maxIdx]<arr[i]){
                maxIdx=i;
            }
        }

        if(maxIdx!=minIdx-1 && minIdx!=maxIdx-1) {
            return false;
        }

        if(maxIdx==minIdx-1){
            for (int i = 1; i <=maxIdx; i++) {
                if(arr[i-1]>arr[i]){
                    return false;
                }
            }
            for (int i = minIdx+1; i <n-1 ; i++) {
                if(arr[i-1]>arr[i]){
                    return false;
                }
            }
            if(arr[0]<arr[n-1]){
                return false;
            }
            return true;
        }
        else if(minIdx==maxIdx-1){
            for (int i = 1; i <=minIdx; i++) {
                if(arr[i-1]<arr[i]){
                    return false;
                }
            }
            for (int i = maxIdx+1; i <n-1 ; i++) {
                if(arr[i-1]<arr[i]){
                    return false;
                }
            }
            if(arr[0]>arr[n-1]){
                return false;
            }
            return true;
        }
        return false;
        }
    }

