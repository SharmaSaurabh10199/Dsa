package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;

/*
n = 3
arr[] = {3, 5, 4}
Output:
1
Explanation:
A triangle is possible with all the elements 5, 3 and 4.
Example 2:
Input:
n = 5
arr[] = {6, 4, 9, 7, 8}
Output:
10
Explanation:
There are 10 triangles possible  with the given elements like
(6,4,9), (6,7,8),...
 */
public class NoOfTriangles {
    public static void main(String[] args) {
        int[] arr={6, 4, 9, 7, 8};
        System.out.println(noOfTriangles(arr,arr.length));
    }
    public static int noOfTriangles(int[] arr,int n){
        Arrays.sort(arr);
        int count=0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if(arr[i]+arr[j]>arr[k]){
                        count++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return count;
    }

}
