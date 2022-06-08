package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;

/*
Describe a ‚.n lg n/-time algorithm that, given a set S of n integers and another
integer x, determines whether or not there exist two elements in S whose sum is
exactly x.
 */
public class PairSum {
    public static void main(String[] args) {
        int[] arr={3,4,5,6,7,8,9};
        int sum= 1;
        System.out.println(pairSum(arr,sum));

    }
    public static boolean pairSum(int[] arr, int x){
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==x){
                return true;
            }
            else if(arr[i]+arr[j]>x){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
