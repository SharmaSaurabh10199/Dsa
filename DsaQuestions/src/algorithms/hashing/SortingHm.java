package algorithms.hashing;

import java.util.*;

//You are given an array a that contains N integers. All the integers in the array may not be distinct.
// The number of repetitions of each integer in the array is represented by ri. Your task is to print the integers
// in the decreasing order of their occurrence in the array.
//
//        Note
//        1. If ri > rj, then ai must be printed before aj.
//        2. If ri == rj, then among ai and aj whichever has a larger value, is printed first.
public class SortingHm {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }

        //int[] arr={1,2,3,3,2,1};
        sortHashmap(arr,arr.length);
    }
    static void sortHashmap(int[] arr,int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
       // System.out.println(hm);
        List<Map.Entry<Integer,Integer>> ls= new ArrayList<Map.Entry<Integer,Integer>>(hm.entrySet());
       // System.out.println(ls);
        Collections.sort(ls, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue()==o2.getValue()){
                    return o2.getKey()-o1.getKey();
                }
                return o2.getValue()-o1.getValue();
            }
        });
       // System.out.println(ls);
        for (Map.Entry<Integer,Integer> lsiter: ls)
              {
                  System.out.println(lsiter.getKey());
        }


    }

}
