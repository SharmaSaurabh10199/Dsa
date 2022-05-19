package algorithms.sorting.Sorts;
/*
Bubblesort is a popular, but inefficient, sorting algorithm. It works by repeatedly
swapping adjacent elements that are out of order.
 */
public class

BubbleSort {
    public static void main(String[] args) {
        int[]arr= {5,2,4,6,1,3};
        // insertionSort(arr);
        bubbleSort(arr);
       // recursiveInsertionSort(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length-1;i++){
            for(int j=arr.length-1; j>i; j--){
                if(arr[j]<arr[j-1]){
                    int temp= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
}
/*
worst case time complexity:
occurs when the array is reverse sorted,

best case time complexity:
occurs when the array is sorted..it can reduced t0 O(n)
 */