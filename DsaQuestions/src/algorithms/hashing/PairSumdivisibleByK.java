package algorithms.hashing;

import java.util.HashMap;
import java.util.Scanner;

/*
Given an array of N integers and an integer K, your task is to calculate the count of pairs whose sum is divisible by K.
5 4
1 2 3 4 5

Sample Output
2
 */
public class PairSumdivisibleByK {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int k =s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();

        }
        System.out.println(countPairs(arr,k));

    }
    static int countPairs(int[]arr, int k){
        int pairCount=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i]%k,hm.getOrDefault(arr[i]%k,0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] % k;
            if (hm.get(key) > 0) {
                hm.put(key, hm.get(key) - 1);
            }
            pairCount += hm.getOrDefault((k - arr[i] % k) % k,0);
        }
        return pairCount;
    }
}
