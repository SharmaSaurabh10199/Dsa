package algorithms.hashing;

import java.util.HashMap;

public class PairSumCount {
    public static void main(String[] args) {

    }
    public static int pairSumCount(int[] arr,int n, int sum){
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(hm.get(arr[i])==null){
                hm.put(arr[i],1);
            }
            else {
                hm.put(arr[i],hm.get(arr[i])+1);
            }
        }
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(sum-arr[i])){
               if((sum-arr[i])==arr[i]){
                   count+= hm.get(sum-arr[i])-1;
               }
               else {
                   count+=hm.get(sum-arr[i]);
               }

            }
        }
        return count/2;
    }

}
