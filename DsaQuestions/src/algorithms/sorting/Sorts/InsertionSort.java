package algorithms.sorting.Sorts;

import java.util.Scanner;

/*
Insertion sort is a simple sorting algorithm that works similar to the way you
sort playing cards in your hands. The array is virtually split into a sorted and an unsorted
part. Values from the unsorted part are picked and placed at the correct position in the sorted part
 */
public class InsertionSort {
    public static void main(String[] args) {
        String[] array= new String[5];
        Scanner s= new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            array[i]=s.next();


        }
        insertionSortForStrings(array);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]+" ");
        }
    }
    // iterative implimentation
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j= i-1;
            int key= arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

    }
    public static void recursiveInsertionSort(int[] arr, int n){
        if(n==1){
            return;
        }
        recursiveInsertionSort(arr,n-1);
        int last= arr[n-1];
        int j=n-2;
        while(j>=0&& arr[j]>last){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=last;
    }
    // insertion sort strings:
    public static void insertionSortForStrings(String[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j= i-1;
            String key= arr[i];
            while(j>=0){
                if(key.compareTo(arr[j])>0){
                    break;
                }
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

    }
}
