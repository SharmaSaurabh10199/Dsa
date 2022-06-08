package algorithms.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestDiff {
    public static void main(String[] args) {
      //  int[] arr={1,3,4,1,3,8};
       // System.out.println(pairCount(arr,1));
       // System.out.println(kthSmallestDigg(arr,2));
        Scanner s=new Scanner(System.in);
        int t= s.nextInt();
        for (int i = 0; i < t; i++) {
            int n= s.nextInt();
            int[] arr= new int[n];
            int k= s.nextInt();
            for (int j = 0; j < n; j++) {
                arr[i]=s.nextInt();
            }
            System.out.println(kthSmallestDigg(arr,k));
        }
    }
    public static boolean pairCount(int[] arr, int threshold,int k){
        int total=0,i=0;
//        int n= arr.length;
//        int j=1;
//        for (int i = 0; i <n ; i++) {
//            while (j<n && (arr[j]-arr[i])<=threshold){
//                j++;
//            }
//            j--;
//            total+=(j-i);
//        }
        for(int j=1;j<arr.length;j++){
            while (arr[j]-arr[i]>threshold){
                i++;
            }
            total=(j-i);
        }
        return total>=k;
    }
    public static int kthSmallestDigg(int[] arr, int k){
        Arrays.sort(arr);
        int lo=0;
        int hi=arr[arr.length-1]-arr[0];

        while (lo<hi){
            int mid=lo+(hi-lo)>>1;
           if(pairCount(arr,mid,k)){
               hi=mid;
           }
            else {
                lo=mid+1;
            }
        }
        return lo;
    }
}
