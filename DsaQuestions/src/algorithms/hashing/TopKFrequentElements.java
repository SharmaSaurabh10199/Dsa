package algorithms.hashing;

import java.util.*;

/*
Given a non-empty array of integers, find the top k elements which have the highest frequency in the array.
If two numbers have the same frequency then the larger number should be given preference.

Note: Print the elements according to the frequency count (from highest to lowest) and if the frequency
is equal then larger number will be given preference.

Example 1:
Input:
N = 6
nums = {1,1,1,2,2,3}
k = 2
Output: {1, 2}
 */
public class TopKFrequentElements {
    public static void findTopkFrequentElements(int[] arr, int k) {
        int n= arr.length;
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < n; i++) {

            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            mp.put(arr[i],
                    mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(mp.entrySet());
        System.out.println(list);
        // Sort the list
        Collections.sort(
                list,
                new Comparator<Map.Entry<Integer,
                        Integer>>() {
                    public int compare(
                            Map.Entry<Integer, Integer> o1,
                            Map.Entry<Integer, Integer> o2) {
                        if (o1.getValue() == o2.getValue())
                            return o2.getKey() - o1.getKey();
                        else
                            return o2.getValue()
                                    - o1.getValue();
                    }
                });
        System.out.println(list);

        for (int i = 0; i < k; i++)
            System.out.println(list.get(i).getKey());
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3,3,4};
        int[] arr2= {1,3,5};
      //  findTopkFrequentElements(arr,3);
        List<int[]> ls= new ArrayList<int[]>();
        ls.add(arr);
        ls.add(arr2);
        System.out.println(ls);
    }
}
