package dataStructures.arrays;

import java.util.HashMap;

/*
Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array.
Your task is to count the frequency of all elements from 1 to N.
Note: The elements greater than N in the array can be ignored for counting.


Example 1:

Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
 */
public class FrequencyCount {
    static void frequencyCount(int[] arr, int n){
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hm.put(i,0);
        }
        for (int i = 0; i < n; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }
        }
        for (int i = 0; i < n; i++) {
                arr[i]=hm.get(i+1);
        }
        //System.out.println(hm);
      //  System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 3, 5};
        frequencyCount(arr,arr.length);
    }
}
