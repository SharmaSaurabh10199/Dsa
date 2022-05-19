package algorithms.hashing;

import java.util.HashMap;

/*
Given an array arr[] of size n containing integers. The problem is to find the length of the longest
 sub-array having sum equal to the given value k.
Examples:


Input : arr[] = { 10, 5, 2, 7, 1, 9 },
            k = 15
Output : 4
The sub-array is {5, 2, 7, 1}.

Input : arr[] = {-5, 8, -14, 2, 4, 12},
            k = -5
Output : 5
----------------------
method 1: O(n2) corresponding to each i, find the maxlength and update it;

method:2 O(n) best optimized solution by hashing
 */
public class

LogestSubArrayWithGivenSum {
    public static void main(String[] args) {
       int[] arr={10,5,2,7,1,9};

      //  System.out.println(longestSubArrayByHashing(arr,-5,arr.length));
//        Scanner s= new Scanner(System.in);
//        int t= s.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n= s.nextInt();
//            int k= s.nextInt();
//            int[] arr= new int[n];
//            for (int j = 0; j <n ; j++) {
//                arr[i]=s.nextInt();
//            }
//            System.out.println(longestSubArrayByHashing(arr,k,n));
//        }
        System.out.println(longestSubArrayByHashing(arr,15,6));


    }
    // naive approach for O(n2) solution
    public static int longestSubArray(int[] arr, int k, int n){
        int maxlength=0;
        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum+=arr[j];
                if(sum==k){
                    if(maxlength<j-i+1){
                        maxlength=j-i+1;
                    }
                }
            }
        }
        return maxlength;
    }
    public static int longestSubArrayByHashing(int[] arr, int k, int n){
        int maxLength=0,sum=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if(sum==k){
                maxLength=i+1;
            }
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
            if(hm.containsKey(sum-k)){
                if(maxLength< i-hm.get(sum-k)){
                    maxLength=i-hm.get(sum-k);
                }
            }

        }
        return maxLength;
    }
}
