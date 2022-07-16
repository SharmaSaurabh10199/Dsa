package algorithms.dp.longestCommonSubSeq;
/*
Given a sequence, find the length of the longest palindromic subsequence in it.
Example :
Input:"bbbab"
Output:4

appraoch: the approach is pretty simple, just reverse the give string and find lcs fro that.
 */
public class LongestPalindromicSubseq {
    public int longestPalinSubseq(String S)
    {
        StringBuilder helper= new StringBuilder(S);
        String rev= helper.reverse().toString();
        int[][] t= new int[S.length()+1][S.length()+1];
        return tabulationApproach(S,rev,S.length(),S.length(),t);

    }
    int tabulationApproach(String x, String y, int n, int m, int[][] t) {
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
        return t[n][m];
    }
}
