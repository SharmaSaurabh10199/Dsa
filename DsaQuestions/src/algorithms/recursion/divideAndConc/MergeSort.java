package algorithms.recursion.divideAndConc;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={-2,4,7,2,0,1};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int start, int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void merge(int[] arr, int start, int mid, int end){
        int[] left= new int[mid-start+1];
        int[] right= new int[end-mid];
        // copy array elements in left array
        for (int i = 0; i < left.length; i++) {
            left[i]=arr[i+start];
        }
        // copy array elements in right array
        for (int i = 0; i < right.length; i++) {
            right[i]=arr[i+mid+1];
        }
        int i=0,j=0,k=start;
        // fill the array back by comparing left and right
        while (i<left.length && j< right.length){
            if(left[i]<right[j]){
                arr[k++]=left[i++];
            }
            else {
                arr[k++]= right[j++];
            }
        }
        while (i< left.length){
            arr[k++]=left[i++];
        }
        while (j< right.length){
            arr[k++]=right[j++];
        }
    }
}
