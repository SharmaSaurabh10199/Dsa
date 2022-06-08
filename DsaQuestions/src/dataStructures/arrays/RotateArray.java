package dataStructures.arrays;
//Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps,
// where D is a positive integer.
/*
Approach1: inplace bys rotating the array.
Approach2: can be done using deque data structre, of course the space complexity will be the trade off.

 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        int d=2;
        rotateLeft(arr,2);
      //  rotateRight(arr,2);
    }
    public static void rotateLeft(int[] arr, int d){
        d=d%arr.length;
        reverse(arr,0,d-1);
        reverse(arr,d,arr.length-1);
        reverse(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void rotateRight(int[] arr, int d){
        d=d%arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,d-1);
        reverse(arr,d,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
