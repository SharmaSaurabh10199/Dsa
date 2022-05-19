package dataStructures.arrays;

import java.util.ArrayList;

/*
Given a non-negative number represented as a list of digits, add 1 to the number
(increment the number represented by the digits). The digits are stored such that the most significant digit is first element of array.
Input:
N = 3
arr[] = {1, 2, 4}
Output:
1 2 5
 */
public class ArrayToNum {
    public static void main(String[] args) {
        int[] arr={1,2,3};
    }
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        int carry=1;
        int sum=0;
        for (int i = N-1; i >=0 ; i--) {
            sum=carry+arr.get(i);
            arr.set(i,sum%10);
            carry=sum/10;
        }
        if(carry>0){
            arr.add(0,carry);
        }
        return arr;
    }

}
