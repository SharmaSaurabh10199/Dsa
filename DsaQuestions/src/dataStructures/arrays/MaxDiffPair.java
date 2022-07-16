package dataStructures.arrays;
/*
Given an array arr[] of N positive integers. Find maximum value of |arr[i] – arr[j]| + |i – j|, (0 <= i, j <= N – 1)



Example 1:

Input:
N = 4
arr[] = {1, 2, 3, 1}
Output:
4
Explanation:
Choosing i=0 and j=2, will result in
|1-3|+|0-2| = 4, which is the maximum
possible value.
-------------------------------------------------------------------------
approach:
First of all lets make four equations by removing the absolute value signs ("|"). The following 4 equations will be formed, and we need to find the maximum value of these equations and that will be our answer.


arr[i] - arr[j] + i - j = (arr[i] + i) - (arr[j] + j)
arr[i] - arr[j] - i + j = (arr[i] - i) - (arr[j] - j)
-arr[i] + arr[j] + i - j = -(arr[i] - i) + (arr[j] - j)
-arr[i] + arr[j] - i + j = -(arr[i] + i) + (arr[j] + j)

Observe the equations (1) and (4) are identical. Similarly, equations (2) and (3) are identical.
Now the task is to find the maximum value of these equations. So the approach is to form two arrays, first_array[], it will store arr[i] + i, 0 <= i < n, second_array[], it will store arr[i] - i, 0 <= i < n.
Now our task is easy, we just need to find the maximum difference between the two values of these two arrays.
For that, we find the maximum value and minimum value in the first_array and store their difference:
ans1 = (maximum value in first_array - minimum value in first_array)
Similarly, we need to find the maximum value and minimum value in the second_array and store their difference:
ans2 = (maximum value in second_array - minimum value in second_array)
Our answer will be a maximum of ans1 and ans2.
 */
public class MaxDiffPair {
    static int findRes(int[] arr, int n){

        int maxa=Integer.MIN_VALUE;
        int mina=Integer.MAX_VALUE;
        int maxb=Integer.MIN_VALUE;
        int minb=Integer.MAX_VALUE;
        int a[]= new int[n];
        int b[]= new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=arr[i]+i;
            b[i]=arr[i]-i;
        }
        for (int i = 0; i < n; i++) {
            if(maxa<a[i]){
                maxa=a[i];
            }
            if(mina>a[i]){
                mina=a[i];
            }
            if(maxb<b[i]){
                maxb=b[i];
            }
            if(minb>b[i]){
                minb=b[i];
            }
        }
        int ans1=maxa-mina,ans2=maxb-minb;
        return Math.max(ans1,ans2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(findRes(arr, arr.length));
    }
}
