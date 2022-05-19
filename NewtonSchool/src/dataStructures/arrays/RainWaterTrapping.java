package dataStructures.arrays;

import java.util.Arrays;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case,6 units of rain water (blue section) are being trapped.
 */
public class RainWaterTrapping {
    public static int trap(int[] height) {
        int n= height.length;
        int water=0;
        int[] maxleft=new int[n];
        int[] maxRight=new int[n];
        maxleft[0]=height[0];
        maxRight[n-1]=height[n-1];
        for (int i = 1; i < n; i++) {
            // keep in mind that minimum value in maxleft can be that array itself, else it'll count
            // negative values for water, same goes for maxRight.
            maxleft[i]=Math.max(maxleft[i-1],height[i]);
        }
        System.out.println(Arrays.toString(maxleft));
        for (int i = n-2; i >=0 ; i--) {
            maxRight[i]=Math.max(maxRight[i+1],height[i]);
        }
        System.out.println(Arrays.toString(maxRight));
        for (int i = 0; i < n; i++) {
            water += Math.min(maxRight[i], maxleft[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
