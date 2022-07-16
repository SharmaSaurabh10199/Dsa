package algorithms.sorting.Sorts;
/*
Approach:
suppose we have two piles of cards face up on a table. Each pile is
sorted, with the smallest cards on top. We wish to merge the two piles into a single
sorted output pile, which is to be face down on the table. Our basic step consists
of choosing the smaller of the two cards on top of the face-up piles, removing it
from its pile (which exposes a new top card), and placing this card face down.
 */
public class
MergeSort {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        mergeSort(arr,2,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


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
        int n1= q-p+1;
        int n2= r-q;
        int l=0,j=0;
        int[] L= new int[n1+1];
        int[] R = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            L[i]=arr[p+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i]=arr[q+1+i];
        }
        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
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
