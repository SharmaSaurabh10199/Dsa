package mockInterviews;

public class dpMedium {
    static int fib( int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
//        System.out.println(fib(5));
//        System.out.println(isPalindrome("nitin"));
        System.out.println(lcs("AGGTAB","GXTXAYB"));
    }
    static boolean isPalindrome(String str){
        if(str.length()==1){
            return true;
        }
        if(str.charAt(0)==str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1,str.length()-1));
        }
        return false;
    }
    /*
    input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3
    “AGGTAB” and “GXTXAYB”
     */
    static int lcs(String str1, String str2){
        int n=str1.length();
        int m= str2.length();
        int[][] dp= new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            for (int j = 0; j < m+1; j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    /*
    for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     */
    static int lis(int[] arr, int n, int[][] dp){
        if(n==1){
            return 1;
        }
        
        if(arr[n-2]>arr[n-1]){
            return lis(arr,n-1,dp);
        }
        else {
            return 1+lis(arr,n-1,dp);
        }
    }
}
