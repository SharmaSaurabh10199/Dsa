package algorithms.recursion.sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void insersionSort(int[] arr, int n){
        if(n==1){
            return;
        }
        insersionSort(arr,n-1);
        int j=n-2;
        int key=arr[n-1];
        while(j>=0 && key<arr[j]){
            arr[j+1]=arr[j];
            j--;
        }
        j++;
        arr[j]=key;
    }

    public static void main(String[] args) {
        int[] arr={5,4,-3,2,1};
        insersionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
