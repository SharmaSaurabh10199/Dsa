package assignments.Feb15;

import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t= s.nextInt();
        for(int k=0; k<t; k++) {
            int n= s.nextInt();
            long key= s.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextLong();
            }

        }
     }
     public static int binarySearch(long[] arr, long key){
         int low=0;
         int high= arr.length-1;
         while(low<=high){
             int mid= low+ (high-low)/2;
             if(arr[mid]==key){
                 return 1;
             }
             else if(arr[mid]<key){
                 low=mid+1;
             }
             else{
                 high=mid-1;
             }
         }
         return -1;
     }
}
