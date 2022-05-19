package algorithms.sorting.Sorts;
/*
approach:
Consider sorting n numbers stored in array A by first finding the smallest element
of A and exchanging it with the element in A[0]. Then find the second smallest
element of A, and exchange it with A[1]. Continue in this manner for the first n-1
elements of A. Write pseudocode for this algorithm, which is known as selection
sort. What loop invariant does this algorithm maintain? Why does it need to run
for only the first n - 1 elements, rather than for all n elements? Give the best-case
and worst-case running times of selection sort in ‚(thita)-notation.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[]arr= {5,2,4,6,1,3};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min=i;
            for(int j= i+1; j<arr.length; j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
}
/*
loop invariants:
1)i<j;
2) 1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.
In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted 
subarray is picked and moved to the sorted subarray.
best case running time:
it"ll occur when array is already sorted, but it is still O(n2).
no exchange bw array elsements occurs, so the time is saved for exchange;

worst case running time:
it"ll occur when the array is reverse sorted, but its still O(n2);
here, maximum possible exchanges occur.
 */
