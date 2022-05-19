package algorithms.sorting.Sorts;

import java.util.Arrays;

public class
QuickSort {
    public static void main(String[] args) {
        int[] arr = {20, 10, 70, 40, 50, 30};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr
        ));
    }

    public static int inPlace(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start, j = start;
        while (j<=end) {
            if (arr[j] <= pivot) {
               if(i!=j){
                   int temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }
                i++;
                j++;

            } else if (arr[j] > pivot) {
                j++;
            }
        }
        return i-1;
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int pi= inPlace(arr, start, end);
        quickSort(arr,start,pi-1);
        quickSort(arr,pi+1,end);
    }
}
