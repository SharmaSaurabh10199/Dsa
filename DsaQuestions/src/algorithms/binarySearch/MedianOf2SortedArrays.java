package algorithms.binarySearch;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/*
approach: the idea is to keep the equal elements in both arrays and all the elments in lwft should be less then or equal
 to right array;
 */
public class

MedianOf2SortedArrays {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
      //  int[] nums1={1,3},nums2={2};
     //   System.out.println(findMedianSortedArrays(nums1.length,nums2.length,nums1,nums2));
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int m= s.nextInt();
        int[] a= new int[n];
        int[] b= new int[m];
        for (int i = 0; i <n ; i++) {
            a[i]=s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i]=s.nextInt();
        }
        String res= df.format(findMedianSortedArrays(n,m,a,b));
        System.out.println(res);
    }
    public static double findMedianSortedArrays(int n, int m,int[] a, int[] b) {
        if(n>m){
            return findMedianSortedArrays(m,n,b,a);
        }
            int begin1 = 0, end1 = n;
            while (begin1 <= end1) {
                int i1 = (begin1 + end1) / 2;
                int i2 = (n + m + 1) / 2 - i1;
                int min1 = i1 == n ? Integer.MAX_VALUE : a[i1];
                int max1 = i1 == 0 ? Integer.MIN_VALUE : a[i1 - 1];
                int min2 = i2 == m ? Integer.MAX_VALUE : b[i2];
                int max2 = i2 == 0 ? Integer.MIN_VALUE : b[i2 - 1];
                if (max2 <= min1 && max1 <= min2) {
                    if ((n + m) % 2 == 0) {
                        return (double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                    } else {
                        return (double) Math.max(max1, max2);
                    }
                } else if (max1 > min2) {
                    end1 = i1 - 1;
                } else {
                    begin1 = i1 + 1;
                }
            }
             return 0.0;
        }

}
/*
Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th
 position of the final sorted array.

Examples:

Input : Array 1 - 2 3 6 7 9
        Array 2 - 1 4 8 10
        k = 5
Output : 6
 */

class kthElementIn2SortedArr{
    public static int result(int n, int m,int[] a, int[] b,int k){
        if(n>m){
            return result(m,n,b,a,k);
        }
        int begin=Math.max(0,k-m);
        int end=Math.min(k,n);
        while (begin<=end){
            int i1= begin+(end-begin)/2;
            int i2= k-i1;
            int min1= i1==n?Integer.MAX_VALUE:a[i1];
            int max1= i1==0?Integer.MIN_VALUE:a[i1-1];
            int min2= i2>=m?Integer.MAX_VALUE:b[i2];
            int max2= i2==0?Integer.MIN_VALUE:b[i2-1];
            if(min1>=max2 && min2>=max1){
                return Math.max(max1,max2);
            }
            else if(max1>min2){
                end=i1-1;
            }
            else {
                begin=i1+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={1, 10, 10, 25, 40, 54, 79};
        int[] b={15 ,24, 27, 32, 33, 39, 48, 68, 82, 88, 90};
        System.out.println(result(a.length,b.length,a,b,15));
    }
}