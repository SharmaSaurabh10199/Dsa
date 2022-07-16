package rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j <n; j++) {
                int low=j+1;
                int high=n-1;
                int remainingSum= target-(nums[i]+nums[j]);
                while (low<high){
                    if(nums[low]+nums[high]<remainingSum){
                        low++;
                    }
                    else if(nums[low]+nums[high]>remainingSum){
                        high--;
                    }
                    else {
                        List<Integer> ls= new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[low]);
                        ls.add(nums[high]);
                        res.add(ls);
                        while (low<high && nums[low]==ls.get(2)){
                            low++;
                        }
                        while (low<high && nums[high]==ls.get(3)){
                            high--;
                        }

                    }

                }

                // for duplicates of j
                while (j+1< n && (nums[j]==nums[j+1])){
                    j++;
                }
            }
            while (i+1<n && (nums[i]==nums[i+1])){
                i++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr={0,0,0,0};
        System.out.println(fourSum(arr,0));
    }

}
