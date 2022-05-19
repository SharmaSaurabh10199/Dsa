package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;

/*
Given two integer arrays A1[ ] and A2[ ] of size N and M respectively. Sort the first array A1[ ] such that all the
 relative positions of the elements in the first array are the same as the elements in the second array A2[ ].
See example for better understanding.
Note: If elements are repeated in the second array, consider their first occurance only.

Example 1:

Input:
N = 11
M = 4
A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
A2[] = {2, 1, 8, 3}
Output:
2 2 1 1 8 8 3 5 6 7 9
 */
public class SortArray1byArray2 {
    public static void main(String[] args) {
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}, A2[] = {99, 22, 444, 56};
         int[] arr= sortA1ByA2(A1,A1.length,A2,A2.length);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        int temp=0;
        for (int i = 0; i < M; i++) {
            for (int j = temp; j < N; j++) {
                if(A1[j]==A2[i]){
                    int swap=A1[temp];
                    A1[temp]=A1[j];
                    A1[j]=swap;
                    temp++;
                }
            }
        }
        mergeSort(A1,temp,N-1);
        return A1;
    }
    public static void mergeSort(int[] arr, int p, int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }
    public static void merge(int[] arr, int p, int q, int r){
        int n1= q-p+2;
        int n2= r-q+1;
        int l=0,j=0;
        int[] L= new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1-1; i++) {
            L[i]=arr[p+i];
        }
        for (int i = 0; i < n2-1; i++) {
            R[i]=arr[q+1+i];
        }
        L[n1-1]=Integer.MAX_VALUE;
        R[n2-1]=Integer.MAX_VALUE;
        for(int k=p; k<=r; k++){
            if(L[l]<R[j]){
                arr[k]=L[l];
                l++;
            }
            else{
                arr[k]=R[j];
                j++;

            }
        }
    }
}
