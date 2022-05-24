package algorithms.dp.longestCommonSubSeq;
/*
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

approach: again this problem is just gentle variation of lcs problem, as its been
         here we will fin the lcs, and return true is length of s=lcs i.e whole
         s is the subsequence
 */
public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int[][] table= new int[s.length()+1][t.length()+1];
        int lcs= tabulationApproach(s,t,s.length(),t.length(),table);
        return s.length()==lcs;

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
