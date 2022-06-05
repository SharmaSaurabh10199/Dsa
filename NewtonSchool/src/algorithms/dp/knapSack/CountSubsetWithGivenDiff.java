package algorithms.dp.knapSack;
/*
problem statment: given an array, you have to find the no of subsets such that their diff = k;

solution1: we have s1-s2= k, s1+s2= sum(of array) => s1= (diff+sum)/2..here assumin s1 is always greater than s2
         this problem is same as count subsets with given sum;

solution2: you can form a table with the given sum. iterate in last row till <=range, check if s1 exist, if it does, than
           check if (range-2s1)==k, if it does, increase count+=2 cause there are 2 subsets.

 */
public class CountSubsetWithGivenDiff {
    int countSubsetsWithGivenDiff(int[] arr, int diff ){
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
}
