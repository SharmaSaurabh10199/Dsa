package algorithms.hashing;

import java.util.HashSet;

/*
Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in
Arr whose sum is exactly X.

Example 1:

Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
 */
public class PairSumExistence {
    public static void main(String[] args) {
     int Arr[] = {1, 4, 45, 4, 10, 8};
     pairSum(Arr,4,6);
    }
    public static boolean  pairSum(int[] arr, int x, int n){
        // using hashmap.
//    /*    Map<Integer,Integer> hm= new HashMap();
//        for (int i = 0; i < n; i++) {
//            if(hm.get(arr[i])==null){
//                hm.put(arr[i],1);
//            }
//            else {
//                hm.put(arr[i],hm.get(arr[i])+1);
//            }
//        }
//        //System.out.println(hm);
//        for (int i = 0; i < n; i++) {
//            if(hm.containsKey(x-arr[i])){
//                if(x-arr[i]!=arr[i]){
//                    return true;
//                }
//                else {
//                    if(hm.get(arr[i])>1){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;

        // using hashset, whenever duplicacy doesn't lead diff results, go for hasset:

        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < n; i++) {
            int temp= x-arr[i];
            if(set.contains(temp)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
