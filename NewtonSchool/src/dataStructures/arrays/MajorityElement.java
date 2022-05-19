package dataStructures.arrays;

import java.util.Arrays;

/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an
 element that appears more than N/2 times in the array.


Example 1:

Input:
N = 3
A[] = {1,2,3}
Output:
-1
Explanation:
Since, each element in
{1,2,3} appears only once so there
is no majority element.
 */
// it could be done more efficiently by using hashing
public class MajorityElement {
    public static void main(String[] args) {
       int[] arr= {3,1,3,3,2};
        System.out.println(resBySorting(arr));
    }
    public static int resBySorting(int[] arr){
        Arrays.sort(arr);
        int count=1;
        //boolean flag=false;
        for(int i=1; i<arr.length; i++){
           // int count=1;
            if(arr[i]==arr[i-1]){
                count++;
                if(count> arr.length/2){
                    return arr[i];
                }
            }
            else {
                count=1;
            }

        }
        return -1;
    }
}
