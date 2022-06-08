package algorithms.twoPointerApproach;

import java.util.Arrays;

/*
Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.

Examples :

Input : arr[] = {0, -1, 2, -3, 1}
Output : (0 -1 1), (2 -3 1)

Explanation : The triplets with zero sum are
0 + -1 + 1 = 0 and 2 + -3 + 1 = 0


Input : arr[] = {1, -2, 1, 0, 5}
Output : 1 -2  1
 */
public class
TripletsWith0Sum {
    public static void main(String[] args) {
        int arr[] =  {1, 2, 3, 4, 5};
        findTriplet(arr,9);
    }
    public static void findTriplet(int[] arr, int x){
        Arrays.sort(arr);
        int l=0,r=arr.length-1;
        boolean found=false;
        while (l<arr.length-2){
            int i=l+1;
            int k=r;
            while (i<k) {
                if (arr[l]+arr[i] + arr[k] == x ) {
                    System.out.println(arr[i]+" "+arr[l]+" "+arr[k]);
                    i++;k--;  // break will discount triplets if there exist more triplets for any l;
                    found=true;
                }
                else if(arr[l]+arr[i] + arr[k] < x ){
                    i++;
                }
                else {
                    k--;
                }
            }
            l++;
        }
        if(found==false){
            System.out.println("triplet doesn't exist");
        }
    }
}
