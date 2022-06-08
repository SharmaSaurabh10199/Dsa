package algorithms.hashing;

import java.util.HashMap;

/*
Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum
of every pair is divisible by k.


Example 1 :

Input : arr = [9, 5, 7, 3], k = 6
Output: True
Explanation: {(9, 3), (5, 7)} is a
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.
 */
public class PairDivisiblityExistence {
    public static boolean canPair(int[] nums, int k) {
        // Code here
        int n= nums.length;
        if(n%2==1){
            return false;
        }
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i]%k,hm.getOrDefault(nums[i]%k,0)+1);
        }
        for (int i = 0; i < n; i++) {
            // for handling the negative values.
            int rem=(nums[i]+k)%k;
            if(rem==0){
                if(hm.get(rem)%2==1){
                    return false;
                }
            }
            else if(2*rem==k){
                if(hm.get(rem)%2==1){
                    return false;
                }
            }
            else if(hm.get(k-rem)!=hm.get(rem)){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr={3,2,11,6,2,12};
        System.out.println(canPair(arr,12));
    }

}
