package rough;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.HashMap;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class LogestConceSeq {
    public int longestConsecutive(int[] nums) {
        int res=1;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i]-1)){
                int count=1;
                while (hm.containsKey(nums[i]+1)){
                    count++;
                    nums[i]++;
                }
                res=Math.max(count,res);
            }
        }
        return res;

    }
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        HashMap<Integer,Integer> hm= new HashMap();
        int sum=0,res=0;
        for(int i=0; i<N; i++){
            sum+=A[i];
            if(sum==K){
                res=i+1;
            }
            if(hm.containsKey(sum-K)){
                res=Math.max(i-hm.get(sum-K),res);
            }
            hm.put(sum,i);
        }
        return res;
    }

}
