package algorithms.dp.knapSack;
// In this question, you have to count the number of subsets with given sum
public class CountSubset {
    // for this perticular question, it assumes that there are only just positive numbers in the matrix. (no zeros), but it get a bit modified for zeros
    // for including zeros too, we don't initialise 1st column, we just intialise first row and proceed.

    // arr=(0,0,1)
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
        int[] arr= {2,3,5,6,8,10};
        System.out.println(solveByTabulation(6,10,arr));
    }
}
