package dataStructures.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int closestsum(int[] arr,int n,int key) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum= arr[i] + arr[j] + arr[k];
                if(sum==key){
                    return sum;
                }
                if (minDiff >= Math.abs(sum - key)) {
                    if (minDiff == Math.abs(sum - key)) {
                        res = Math.max(res, sum);
                    } else {
                        minDiff = Math.abs(sum - key);
                        res = sum;
                    }
                }
                if (arr[i] + arr[j] + arr[k] > key) {
                        k--;
                } else {
                        j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={-7 ,9 ,8 ,3 ,1 ,1};
        System.out.println(closestsum(arr,arr.length,2));
    }

}
