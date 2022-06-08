package dataStructures.arrays;

/*
which can be made subarray of all 1 after
flipping two zeros to 1.
Example 2:

Input:
N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output:
8
Explanation:
Maximum subarray is of size 8
which can be made subarray of all 1 after
flipping two zeros to 1
 */
public class
Maximum1s {

// this is the way i have done all my sliding window problems, imma stick to it

       static int max1(int[] arr, int m){
           int i=0, j=0, max=-1,count=0;
           while (j<arr.length){
               if(arr[j]==0){
                   count++;
               }
               if(count<=m){
                   max=Math.max(max,j-i+1);
                   j++;
               }
               else{
                   while (count>m){
                       if(arr[i]==0){
                           count--;
                       }
                       i++;
                   }
                   // as one possible result could lie here.
                   if(count==m){
                       max=Math.max(max,j-i+1);
                   }
                   j++;
               }

           }
           return max;
       }


    public static void main(String[] args) {
        int[] arr= {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
       // System.out.println(max1s(arr,2));
        System.out.println(max1(arr,2));
    }
}
