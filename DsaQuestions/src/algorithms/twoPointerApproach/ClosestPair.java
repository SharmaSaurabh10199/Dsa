package algorithms.twoPointerApproach;
/*
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that
 absolute value of (ar1[i] + ar2[j] – x) is minimum.
Example:

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32
Output:  1 and 30
 */
public class ClosestPair {
    public static void main(String[] args) {
       int  ar1[] = {1, 4, 5, 7};
       int   ar2[] = {10, 20, 30, 40};
       findPair(ar1,ar2,18);
    }
    public static void findPair(int[] arr1,int[] arr2,int x){
        int i=0,resi=0,j=arr2.length-1, resj=arr2.length-1, min=Integer.MAX_VALUE;
        while (i<arr1.length && j>=0){
//            if(arr1[i]+arr2[j]>x){
//                if(min> Math.abs(arr1[i]+arr2[j]-x)) {
//                    min = Math.abs(arr1[i] + arr2[j] - x);
//                    resi = i;
//                    resj = j;
//                }
//                j--;
//            }
            if(Math.abs(arr1[i]+arr2[j]-x)<min){
                min=Math.abs(arr1[i]+arr2[j]-x);
                resi=i;
                resj=j;
            }
             if(arr1[i]+arr2[j]>x){
                j--;
            }
            else{
                i++;
            }
//            else {
//                if(min< Math.abs(arr1[i]+arr2[j]-x)) {
//                    min = Math.abs(arr1[i] + arr2[j] - x);
//                    resi = i;
//                    resj = j;
//                }
//                i++;
//            }

        }
        System.out.println(arr1[resi]+" "+arr2[resj]);
    }
}
