package algorithms.dp.knapSack;
/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3



--> solution:
   this problem is exactly same as the subsets with given sum problem. here the given sum can be interpreted as the diff as we are
   using both = and - signs
 */
public class TargetSum {
    static public int findTargetSumWays(int[] arr, int diff) {
        int sum=0;
        for(int item: arr){
            sum+=item;
        }
        // additional test cases
        /*
        here since the sum of 2 subsets will always be greater than their diff, and and it will never be fraction because
        we have integers in our array.
         */
        if(sum-diff<0 || (sum-diff)%2==1){
            return 0;
        }
        // now count the subsets with given sum
        return solveByTabulation(arr.length,(sum-diff)/2,arr);

    }
    static int solveByTabulation(int n , int sum, int[] arr){
        int[][] t= new int[n+1][sum+1];
        t[0][0]=1;
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(arr[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                else {
                    t[i][j]=t[i-1][j] + t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[]arr={0,0,0,0,0,0,0,0,1,
        };
        System.out.println(findTargetSumWays(arr,1));
    }

}
