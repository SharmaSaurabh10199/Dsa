package algorithms.dp.longestCommonSubSeq;
/*
Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
Examples:

Input:   str1 = "geek",  str2 = "eke"
Output: "geeke"


appproach: the approach is very simple here, we just need to find the length of common sebseq and subtract it from the
      sum of the lrngth of 2 strings;
      ans= l1+l2-lcs
 */
public class ShortestCommonSuperseq {
    static int result(String s1, String s2){
        int[][] t= new int[s1.length()+1][s2.length()+1];
        int lcs= tabulationApproach(s1,s2,s1.length(),s2.length(),t);
        return s1.length()+s2.length()-lcs;
    }
    static int tabulationApproach(String x, String y, int n, int m, int[][] t) {
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
