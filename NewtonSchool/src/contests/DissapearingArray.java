package contests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DissapearingArray {
    public static void displayMissing(int[] arr, int n){
//        HashMap<Integer,Integer> hm= new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            hm.put(arr[i],hm.getOrDefault(arr[i]))
//        }
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for (int i = 1; i <=n ; i++) {
            if(!set.contains(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr={4,1,3,2,5,5,4};
//        displayMissing(arr,arr.length);
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        long[] arr= new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextLong();
        }
        //displayMissing(arr,n);
    }
}
