package algorithms.twoPointerApproach;

import java.util.Arrays;

/*
Given an array arr[] and an integer sum, the task is to find the number of pairs of integers in the array whose sum
is equal to sum.
Input: arr[] = {1, 5, 7, -1}, sum = 6
Output: 2
Pairs with sum 6 are (1, 5) and (7, -1)
Input: arr[] = {1, 5, 7, -1, 5}, sum = 6
 */
public class CountPairForgivenSum {
    public static void main(String[] args) {
        int arr[] =  {4,4,5,6,6};
        System.out.println(countPairSum(arr,arr.length,10));
    }
    public static int countPairSum(int[] arr, int n,int sum) {
        Arrays.sort(arr);
        int i = 0, j = n - 1, ans = 0;
        while (i < j) {
            if (arr[i] + arr[j] > sum) {
                j--;
            } else if (arr[i] + arr[j] < sum) {
               i++;
            }
            else {
                int x=arr[i], y=arr[j];
                if(x==y){   // in this case the ans will be nc2
                  int k= (j-i+1);
                  ans+= k*(k-1)/2;
                  break;// kc2
                }
                else{      // the ans will be the (no of same elements in i)*(no of same elements in j)
                    int idxi=i, idxj=j;
                    while (arr[i]==x){
                        i++;
                    }
                    while (arr[j]==y){
                        j--;
                    }
                    ans+=(i-idxi)*(idxj-j);
                }
            }
        }
        return ans;
    }

}
