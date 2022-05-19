package dataStructures.arrays;

import java.util.Arrays;

/*
Given an array arr[] of size n, its prefix sum array is another array prefixSum[] of the same size,
such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].

Examples :

Input  : arr[] = {10, 20, 10, 5, 15}
Output : prefixSum[] = {10, 30, 40, 45, 60}
 */
public class PrefixSum {
    public static void main(String[] args) {
     int[] arr= {10, 20, 10, 5, 15};
     prefixSum(arr,0, arr.length-1);
    }
    public static void  prefixSum(int[] arr, int start, int end){
//       int[] arrNew= new int[arr.length+1];
//        int sum=0;
//        for(int i=0; i<arr.length; i++){
//            arrNew[i]=sum;
//            sum+=arr[i];
//        }
//        arrNew[arr.length]=sum;
//        int res= arrNew[end]-arrNew[start-1];
//        return res;
        int sum=0;
        for (int i = start; i <=end ; i++) {
            sum+=arr[i];
            arr[i]=sum;
        }
        System.out.println(Arrays.toString(arr));
    }
}
