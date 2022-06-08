package algorithms.dp.longestCommonSubSeq;
/*
Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.

approach:
while traversing check if the values don't match, fill them as 0 as we start again.
 */
public class LongestCommonSubString {
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] t= new int[n+1][m+1];
        int max= 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i==0 || j==0){
                    t[i][j]=0;
                }
                else if(S1.charAt(i-1)==S2.charAt(j-1)){
                    t[i][j]= 1+t[i-1][j-1];
                    if(max<t[i][j]){
                        max=t[i][j];
                    }
                }
                else {
                    t[i][j]=0;
                }
            }
        }
        return max;
    }

}
