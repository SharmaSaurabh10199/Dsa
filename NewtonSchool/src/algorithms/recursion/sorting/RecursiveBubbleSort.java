package algorithms.recursion.sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void recursiveBubble(int[] arr, int n){
        if(n==1){
            return;
        }
        for (int i = 0; i < n-1; i++) {
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        recursiveBubble(arr,n-1);
    }

    public static void main(String[] args) {
        int[] arr={5,4,-3,2,1};
        recursiveBubble(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
