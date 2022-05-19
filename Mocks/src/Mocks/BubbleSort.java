package Mocks;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,6,7,8};
        sort(arr,arr.length);

    }
    public static void sort(int[] arr, int n){
        for(int i=n-1;i>0;i--){
            boolean flag=true;
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag= false;
                }

            }
            if(flag==true){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
