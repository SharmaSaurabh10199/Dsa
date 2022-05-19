package dataStructures.arrays;
/*
Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the

product of all the elements of nums except nums[i].



Example 1:

Input:
n = 5
nums[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation:
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
 */
public class ProductArray {
    public static void main(String[] args) {

    }
    public static long[] productExceptSelf(int nums[], int n)
    {
        //
        // code here
       int[] prefix=new int[n];
       int[] suffix= new int[n];
       long[] product= new long[n];
       prefix[0]=1;suffix[n-1]=1;
       int prefixProduct=1, suffixProduct=1;
        for (int i = 1; i < n; i++) {
            prefixProduct*=nums[i-1];
            prefix[i]=prefixProduct;
        }
        for(int i=n-2;i>=0;i--){
            suffixProduct*=nums[i+1];
            suffix[i]=suffixProduct;
        }
        for (int i = 0; i < n; i++) {
            product[i]=prefix[i]*suffix[i];
        }
      return product;
    }

}
