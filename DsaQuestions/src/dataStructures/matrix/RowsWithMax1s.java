package dataStructures.matrix;
/*
Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input:
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).
Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)
 */
public class RowsWithMax1s {
    public static void main(String[] args) {
     int Arr[][] = {{0, 1, 1, 1},
             {0, 0, 1, 1},
             {1, 1, 1, 1},
             {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(Arr));
    }
    public static int noOf1s(int[] arr){
        int m=arr.length;
        int lo=0;
        int hi=m-1;
        int res=-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if((mid==0 || arr[mid-1]==0)&& arr[mid]==1){
                res=m-mid;
                break;
            }
            else if(arr[mid]==0){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return res;
    }
    public static int rowWithMax1s(int[][] mat){
        int max=-1;
        int r0w=-1;
        for (int i = 0; i < mat.length; i++) {
            if(max<noOf1s(mat[i])){
                max=noOf1s(mat[i]);
                r0w=i;
            }
        }
        return r0w;
    }
}
