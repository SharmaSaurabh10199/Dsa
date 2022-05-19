package Mocks;

import java.util.HashMap;

// 1 2 3 4 1 2 3 1 2 1 1 2 3 4 1 2 3;
public class maxOccuring {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,1,2,31,2,1,1,2,3,4,1,2,3,};
        System.out.println(maxOccuring(arr,arr.length));
    }
    public static int maxOccuring(int[] arr, int n){
        HashMap<Integer,Integer> hm= new HashMap<>();
        int max=0, res=-1;
        for (int i = 0; i < n; i++) {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < n; i++) {
            if(max<hm.get(arr[i])){
                max=hm.get(arr[i]);
                res=arr[i];
            }
        }
        return max;
    }
}
