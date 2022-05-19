package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....

If there are multiple solutions, find the lexicographically smallest one.

Example 1:

Input:
n = 5
arr[] = {1,2,3,4,5}
Output: 2 1 4 3 5

 */
public class WaveArray {
    public static void main(String[] args) {
      //  int[] arr={1,2,3,4,5};
      //  System.out.println(Arrays.toString(waveArray(arr)));
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int[] array= new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=s.nextInt();
        }
        waveArray(array);
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }
    public static void waveArray(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i+=2) {
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }

    }
}
