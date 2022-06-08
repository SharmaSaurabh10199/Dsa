package algorithms.recursion.sorting;

import java.util.Arrays;

public class RecursiveSelectionSort {
    public static void selectionSort(int[] arr,int n){
        if(n==1){
            return;
        }
        // sorting being performed while moving towards base case
        int max=n-1;
        for (int i = 0; i < n-1; i++) {
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        if(max!=n-1){
            int temp=arr[max];
            arr[max]=arr[n-1];
            arr[n-1]=temp;
        }
        selectionSort(arr,n-1);
        // while coming back its not possble to sort the array cus we are not considerin g all the elements of the arrays
        // while moving back unlike we didi while moving towards the base case;
//        int min=0;
//        for (int i = 1; i < n; i++) {
//            if(arr[min]>arr[i]){
//                min=i;
//            }
//        }
//        if(min!=0){
//            int temp=arr[min];
//            arr[min]=arr[0];
//            arr[0]=temp;
//        }

    }

    public static void main(String[] args) {
        int arr[]={5,4,-3,2,1};
        selectionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
