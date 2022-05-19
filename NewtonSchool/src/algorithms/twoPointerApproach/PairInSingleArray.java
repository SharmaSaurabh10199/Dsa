package algorithms.twoPointerApproach;
/*
Given a sorted array and a number x, find a pair in an array whose sum is closest to x.

Examples:

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
 */
public class PairInSingleArray {
    public static void main(String[] args) {
        int arr[] = {10, 22, 28, 29, 30, 40}, x = 100;
        findClosestPair(arr,x);
    }
    public static void findClosestPair(int[] arr, int x){
        int i=0, j=arr.length-1,min=Integer.MAX_VALUE,resi=0,resj=arr.length-1;
        while (i<j){
            if(Math.abs(arr[i]+arr[j]-x)<min){
                min=Math.abs(arr[i]+arr[j]-x);
                resi=i;
                resj=j;
            }
            if(arr[i]+arr[j]>x){
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println(arr[resi]+" "+arr[resj]);
    }
}
