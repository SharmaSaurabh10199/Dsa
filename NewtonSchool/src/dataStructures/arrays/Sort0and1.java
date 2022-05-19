package dataStructures.arrays;

import java.util.Arrays;

// sort the array of 0s, and 1s in o(n);
public class Sort0and1 {
    public static void main(String[] args) {
        int[] arr= {0,1,0,1,0,1,1};
        sort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void sort(int[] arr){
        int i=0, j=0;
        while(j<arr.length){
            if(arr[j]==0){
                if(i!=j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                    i++;
                    j++;

            }
            else{
                j++;
            }
        }
    }
}
class Sort012{
    public static void main(String[] args) {
        int[] arr={2,0,1,2,2,0,0,1,1,1,};
        dns(arr,arr.length);
        sort012(arr,arr.length);
    }
    // counting the no of 0,1,2. and filling the array again.
    static void sort012(int[] arr,int n){
        int c0=0,c1=0,c2=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==0){
                c0++;
            }
            else if(arr[i]==1){
                c1++;
            }
            else {
                c2++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(c0>0){
                arr[i]=0;
                c0--;
            }
            else if(c1>0){
                arr[i]=1;
                c1--;
            }
            else if(c2>0){
                arr[i]=2;
                c2--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    // the dutches national flag algorithm:
    /*
    steps:
    1) take 3 pointers,low high and mid pointing to first, first and last index respectively;
    2) if arr[mid]=0, swap arr[low], arr[mid] and increase both.
    3) if arr[mid]=1, increament mid;
    4) if arr[mid]=2,swap mid,high and decrement high.

     */
    static void dns(int[] arr, int n){
        int low=0,mid=0,hi=n-1;
        while (mid<=hi){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                swap(arr,mid,hi);
                hi--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    static void swap(int[] arr,int idx1,int idx2){
        int temp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
    }

}

