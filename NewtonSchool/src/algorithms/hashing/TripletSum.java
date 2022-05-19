package algorithms.hashing;

import java.util.HashSet;

/*
Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.


Example 1:

Input:
n = 6, X = 13
arr[] = [1 4 45 6 10 8]
Output:
1
Explanation:
The triplet {1, 4, 8} in
the array sums up to 13.
 */
public class TripletSum {
    public static boolean tripletSum(int[] arr,int n,int x){
        if(n<3){
            return false;
        }

        for (int i = 0; i < n-2; i++) {
            HashSet<Integer> set= new HashSet<>();
            for (int j = i+1; j < n; j++) {
                if(set.contains(x-arr[i]-arr[j])){
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }

}
