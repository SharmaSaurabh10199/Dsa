package algorithms.sorting.ApplicationAndQuestions;

import java.util.Scanner;

/*
2-4 Inversions
Let A[1...n] be an array of n distinct numbers. If i<j and A[i] > A[j], then the
pair i and j is called an inversion of A.
a. List the five inversions of the array {2,3,8,6,1};

b. What array with elements from the set {1,2,3,...n} has the most inversions?
How many does it have?
c. What is the relationship between the running time of insertion sort and the
number of inversions in the input array? Justify your answer.
d. Give an algorithm that determines the number of inversions in any permutation
on n elements in n lg n/ worst-case time. (Hint: Modify merge sort.)
 */
public class NoOfInversions {
    static int count=0;
    public static void main(String[] args) {
    //    int[] arr={1,1,3,2,2};
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        countInversions(arr,0,arr.length-1);
        System.out.println(count);
    }
    public static void  countInversions(int[]arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q=(p+r)/2;
        countInversions(arr,p,q);
        countInversions(arr,q+1,r);
        merge(arr,p,q,r);

    }
    public static void merge(int[] arr, int p, int q, int r){
            int n1 = q - p + 2;
            int n2 = r - q + 1;
            int l = 0, j = 0;

            int[] L = new int[n1];
            int[] R = new int[n2];
            for (int i = 0; i < n1 - 1; i++) {
                L[i] = arr[p + i];
            }
            for (int i = 0; i < n2 - 1; i++) {
                R[i] = arr[q + 1 + i];
            }
            L[n1 - 1] = Integer.MAX_VALUE;
            R[n2 - 1] = Integer.MAX_VALUE;
            for (int k = p; k <= r; k++) {
                if (L[l] <=R[j]) {
                    arr[k] = L[l];
                    l++;
                } else {
                    count = count + (n1 - 1 - l);
                    arr[k] = R[j];
                    j++;

                }
            }
        }
}
