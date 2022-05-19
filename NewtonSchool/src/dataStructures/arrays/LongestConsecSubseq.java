package dataStructures.arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence
 are consecutive integers, the consecutive numbers can be in any order.


Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6
numbers form the longest consecutive
subsquence.
 */
public class LongestConsecSubseq {
    // nlogn approach
    static int findlogestConsecSubsequesnce(int[] arr,int n){
        Arrays.sort(arr);
        int count=1,max=-1;
        for (int i = 1; i < n; i++) {

            if(arr[i]==arr[i-1] || arr[i]==arr[i-1]+1){
                if(arr[i]==arr[i-1]+1){
                    count++;
                    max=Math.max(max,count);
                }
            }

            else {
                count=1;
            }
        }
        return max;
    }
    // by using hashing in o(n) approach;
    public static int result(int[] arr){
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int ans=1;
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i]-1)) {
                int count = 1;
                int temp=arr[i];
                while (set.contains(temp + 1)) {
                    temp++;
                    count++;
                }
                ans = Math.max(count, ans);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1,2,2,3,3,3,4,5,6,7};
        System.out.println(findlogestConsecSubsequesnce(a,a.length));
    }
}
