package algorithms.twoPointerApproach;

import java.util.Arrays;
import java.util.Scanner;

/*

Given an array Arr[] of size N, your task is to count the number of triplets Arr[i], Arr[j] and Arr[k] such that:-
i < j < k and the difference between every 2 elements of triplets is less than or equal to P i. e |Arr[i] - Arr[j]| <= P,
 |Arr[i] - Arr[k]| <= P and |Arr[j] - Arr[k]| <= P
 */
public class DTriplets_assignment {
    public static void main(String[] args) {
   //  int[] arr={1,3,2,9,5};
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int p= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
            System.out.println(coutDtriplets(arr, 3,arr.length));
        }

    }
    public static long coutDtriplets(int[] arr, int p,int n){
        Arrays.sort(arr);
        long count=0;
        for (int i = 0; i < n-2; i++) {
            int k=n-1;
            while (i+1<k){
                int diff= arr[k]-arr[i];
                if(diff>p){
                    k--;
                }
                else {
                    count+=k-(i+1);
                    k--;
                }
            }
        }
        return count;
    }
}
