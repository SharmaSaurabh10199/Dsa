package algorithms.backTracking;

import java.util.ArrayList;

/*
Given two integers N and K, find the Kth permutation sequence of numbers from 1 to N without using STL function.
Note: Assume that the inputs are such that Kth permutation of N number is always possible.

Examples:

Input: N = 3, K = 4
Output: 231
 */
public class kthPermutation {
    static String kthPermutaion(int k, int n){
        ArrayList<Integer> ls= new ArrayList<>();
        long fact=1;
        for (int i = 1; i < n; i++) {
            fact*=i;
            ls.add(i);
        }
        String ans="";
        ls.add(n);
        k=k-1;
        while (true){
            int idx= (int) (k/fact);
            ans= ans+ ls.get(idx);
            ls.remove(idx);
            if(ls.size()==0){
                break;
            }
            k= (int) (k%fact);
            fact=fact/ls.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(kthPermutaion(7,10000));
    }
}
