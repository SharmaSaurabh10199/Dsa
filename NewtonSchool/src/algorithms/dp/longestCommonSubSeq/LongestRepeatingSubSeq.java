package algorithms.dp.longestCommonSubSeq;
/*
Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
Example:
Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a'
(second). Note that 'b' cannot be considered
as part of subsequence as it would be at same
index in both.

approach:
       this problem is just a gentle variation of lcs problem itself, since repeating subseq is asked.
       we copy and make one more string same as that, and find the lcs for them such that i!=j;

 */
public class LongestRepeatingSubSeq {
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        String str2= new String(str);
        int[][] t= new int[str.length()+1][str.length()+1];
        return tabulationApproach(str,str2,str.length(),str.length(),t);
    }
    static int tabulationApproach(String x, String y, int n, int m, int[][] t) {
        // base condition
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i==0 || j==0){
                    t[i][j]=0;
                }
                else if((x.charAt(i-1)==y.charAt(j-1)) && i!=j){
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
