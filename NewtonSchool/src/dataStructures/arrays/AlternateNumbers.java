package dataStructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive
 and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with positive number.


Example 1:

Input:
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
Example 2:

Input:
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0
 */
public class AlternateNumbers {
    public static void main(String[] args) {
        int[] arr={9 ,4, -2, -1, 5, 0, -5, -3, 2};
        alternateArray(arr,arr.length);
        rearrange(arr,arr.length);
    }
    // though this is giving right results, its kinda fucked uo code;
    static void alternateArray(int[] arr, int n){
        int i=0,j=0,k=0;
        int[] brr= new int[n];
        while(arr[i]>=0){
            i++;
        }
        while (arr[j]<0){
            j++;
        }
        // 9 -2 4 -1 5 -5 0 -3 2
        while (i<n && j<n){
            brr[k++]=arr[j++];
            brr[k++]=arr[i++];
            if(i>=n || j>=n){
                break;
            }
            while(i<n  && arr[i]>=0){
                i++;
            }
            while (j<n && arr[j]<0  ){
                j++;
            }
        }
        if(j<n){
            while (j<n && arr[j]>=0 ){
                brr[k++]=arr[j++];
            }
        }
        else {
            while (i<n && arr[i]<0){
                brr[k++]=arr[k++];
            }
        }
        System.out.println(Arrays.toString(brr));
        arr=brr;
    }
    static void rearrange(int[] arr, int n){
        int i=0,j=0;
        ArrayList<Integer> ls1=new ArrayList<>();
        ArrayList<Integer> ls2= new ArrayList<>();
        while (i<n){
            if(arr[i]<0){
                ls1.add(arr[i]);
            }
            else {
                ls2.add(arr[i]);
            }
            i++;
        }
        for (int k = 0; k < ls1.size() || k< ls2.size() ; k++) {
            if(k<ls2.size()){
                arr[j]=ls2.get(k);
                j++;
            }
            if(k< ls1.size()){
                arr[j]=ls1.get(k);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
