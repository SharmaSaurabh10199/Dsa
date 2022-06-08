package mockInterviews;

public class targetSum {
    static boolean targetSum(int[] arr, int target){
        boolean[][] t= new boolean[arr.length+1][target+1];
        for(int i=0; i<arr.length+1 ; i++){
            t[i][0]=true;
        }
        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < target+1; j++) {

                if(i!=0 && arr[i-1]>j ){
                    t[i][j]=t[i-1][j];
                }
                else{
                    t[i][j]= t[i-1][j] || t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[arr.length][target];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2}, sum = 13;
        System.out.println(targetSum(set,sum));
    }
}
