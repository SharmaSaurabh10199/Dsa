package algorithms.hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
Given two arrays a[] and b[] respectively of size n and m, the task is to print the count of elements in the
intersection (or common elements) of the two arrays.

For this question, the intersection of two arrays can be defined as the set containing distinct common elements between the two arrays.

Example 1:

Input:
n = 5, m = 3
a[] = {89, 24, 75, 11, 23}
b[] = {89, 2, 4}

Output: 1

Explanation:
89 is the only element
in the intersection of two arrays.
Example 2:

Input:
n = 6, m = 5
a[] = {1, 2, 3, 4, 5, 6}
b[] = {3, 4, 5, 6, 7}

Output: 4

Explanation:
3 4 5 and 6 are the elements
in the intersection of two arrays.
Your Task:
You don't need to read input or print anything. Your task is to complete the function NumberofElementsInIntersection()
 which takes two integers n and m and their respective arrays a[] and b[]  as input. The function should return the count
  of the number of elements in the intersection.



Expected Time Complexity: O(n + m).
Expected Auxiliary Space: O(min(n,m)).
 */
public class
ArrayIntersection {
    // this ncludes duplicates if exists:
    public static int findIntersection(int a[], int b[], int n, int m){
        int count=0;
        if(n<m){
            return findIntersection(b,a,m,n);
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < m; i++) {
            hm.put(b[i],hm.getOrDefault(b[i],0)+1);
        }
        for (int i = 0; i < n; i++) {
            if(hm.containsKey(a[i])&& hm.get(a[i])>0){
                count++;
                hm.put(a[i],hm.get(a[i])-1);
            }
        }
        System.out.println(hm);
        return count;
    }
    // this find the intersection and removes duplicates, or the set of intersection of 2 arrays,
    // exactlt what the question asks;
    public static int intersectionSet(int a[], int b[], int n, int m){
        int count=0;
        if(n<m){
            return findIntersection(b,a,m,n);
        }
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        for(int i=0;i<m; i++){
            set1.add(b[i]);
        }
        for(int i=0; i<n;i++){
            set2.add(a[i]);
        }
        for(Integer i: set1){
            if(set2.contains(i)){
                count++;
            }
        }
        return count;

    }
    // finds the union of 2 arrays
    public static void union(int[] a, int[] b, int n, int m){
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<m; i++){
            set.add(b[i]);
        }
        for(int i=0; i<n;i++){
            set.add(a[i]);
        }
        // set is the union
        System.out.println(set);
    }

    public static void main(String[] args) {
        int[] arr={1,2};
        int[] brr={1,2,2,3,4};
        System.out.println(findIntersection(arr,brr,arr.length,brr.length));
    }

}
