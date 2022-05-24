package algorithms.dp.longestCommonSubSeq;
/*
Given two sequences, print the longest subsequence present in both of them.
Example:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

// the approach is first making the table for lcs and then moving in that table from end to 0,0 and appending the results in the way.
 */
public class PrintingLcs {
    static String lognestSubsequence(String x, String y){
        int[][] t= new int[x.length()+1][y.length()+1];
        tabulationApproach(x,y,x.length(),y.length(),t);
        StringBuilder res= new StringBuilder();
        int i=x.length();
        int j=y.length();
        while (i>0 && j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                res.append(x.charAt(i-1));
                i--;j--;
            }
            else {
                if(t[i-1][j]>t[i][j-1]){
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        return res.reverse().toString();
    }
    // another approach is keeing the result in the string only and maupulating the result accordingly

    static void tabulationApproach(String x, String y, int n, int m, int[][] t) {
        // base condition
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i==0 || j==0){
                    t[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    t[i][j]= 1+t[i-1][j-1];
                }
                else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
    }


    public static String longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        String dp[][]=new String[n+1][m+1];
        for(int i=0;i<m+1;i++)
            dp[0][i]="";
        for(int i=0;i<n+1;i++)
            dp[i][0]="";

        for(int r=1;r<n+1;r++){
            for(int c=1;c<m+1;c++){
                if(text1.charAt(r-1)==text2.charAt(c-1)){
                    StringBuffer str=new StringBuffer(dp[r-1][c-1]);
                    str.append(text1.charAt(r-1));
                    dp[r][c]=str.toString();
                }
                else{
                    if(dp[r-1][c].length()>=dp[r][c-1].length())
                        dp[r][c]=  dp[r-1][c];
                    else
                        dp[r][c]=  dp[r][c-1];

                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcdaf","acbcf"));
    }
}
