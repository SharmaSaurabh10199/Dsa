package algorithms.dp.longestCommonSubSeq;
/*
Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest supersequence exists, print any one of them.

Examples:

Input: X = "AGGTAB",  Y = "GXTXAYB"
Output: "AGXGTXAYB" OR "AGGXTXAYB"
OR Any string that represents shortest
supersequence of X and Y

Input: X = "HELLO",  Y = "GEEK"
Output: "GEHEKLLO" OR "GHEEKLLO"
OR Any string that represents shortest
supersequence of X and Y

approach: this question is just a gent;le variation of printing lcs, just that we have to print all the cells while movinf in
that matrix while we just pprinted some selected cells in case of lcs.

 */
public class PrintScs {
    static String printScs(String x, String y){
        int[][] t= new int[x.length()+1][y.length()+1];
        tabulationApproach(x,y,x.length(),y.length(),t);
        StringBuilder res= new StringBuilder();
        int i=x.length();
        int j=y.length();
        while (i>0 && j>0){

            if(x.charAt(i-1)==y.charAt(j-1)){
                // moving diagonally back, value from both string is included.
                res.append(x.charAt(i-1));
                i--;j--;
            }
            else {
                // moving upwards, string x should be appended
                if(t[i-1][j]>t[i][j-1]){
                    res.append(x.charAt(i-1));
                    i--;
                }
                // moving back, char of y should be appended.
                else {
                    res.append(y.charAt(j-1));
                    j--;
                }
            }
        }
       // appending the remaining y string if any
        while (j>0){
            res.append(j-1);
            j--;
        }
        // appending the remaining x string if any
        while (i>0){
            res.append(i-1);
            i--;
        }
        return res.reverse().toString();
    }


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

    public static void main(String[] args) {
        System.out.println(printScs("abcdaf","acbcf"));
    }
}
