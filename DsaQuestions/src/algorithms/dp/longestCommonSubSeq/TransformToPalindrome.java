package algorithms.dp.longestCommonSubSeq;
/*
Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
Examples :

Input : aebcbda
Output : 2
Remove characters 'e' and 'd'
Resultant string will be 'abcba'
which is a palindromic string

approach: this is just a gentle varioation of the longest palindromic subseq problem:
     res= str.length-longest palindromic subseq.
 */
public class TransformToPalindrome {
    int minDeletions(String str, int n)
    {
        return str.length()-longestPalinSubseq(str);

    }
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
