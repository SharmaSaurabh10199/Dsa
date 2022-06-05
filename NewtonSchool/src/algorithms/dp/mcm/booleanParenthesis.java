package algorithms.dp.mcm;
/*
Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.



Example 1:

Input: N = 7
S = T|T&F^T
Output: 4
Explaination: The expression evaluates
to true in 4 ways ((T|T)&(F^T)),
(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: N = 5
S = T^F|F
Output: 2
Explaination: ((T^F)|F) and (T^(F|F)) are the
only ways.


---> the ans might not be as aptimized or maybe having errors but the approach is pretty clear.
 */
public class booleanParenthesis {

    static int countWays(int N, String S){
        // code here
        int[][][] mat= new int[N+1][N+1][2];

        return solve(0,N-1,S,1,mat);
    }
    static int solve(int i, int j, String s, int isTrue,int[][][] mat){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue==1){
                if(s.charAt(i)=='T'){
                    return 1;
                }
                return 0;
            }
            else {
                if(s.charAt(i)=='F'){
                    return 1;
                }
                return 0;
            }
        }
        if( mat[i][j][isTrue]!=0){
            return mat[i][j][isTrue];
        }
        int ans=0;
        for (int k = i+1; k < j; k+=2) {
            int lt= solve(i,k-1,s,1,mat);
            int lf= solve(i,k-1,s,0,mat);
            int rt= solve(k+1,j,s,1,mat);
            int rf= solve(k+1,j,s,0,mat);
            if(s.charAt(k)=='|'){
                if(isTrue==1){
                    ans+= lt*lf+ lt*lt+ lf*lt;
                }
                else {
                    ans+=lf*lf;
                }
            }
            else if(s.charAt(k)=='&'){
                if(isTrue==1){
                    ans+=lt*lt;
                }
                else {
                    ans+=lf*lf + lt*lf + lf*lt;
                }
            }
            else if(s.charAt(k)=='^'){
                if(isTrue==1){
                    ans+= lf*lt + lt*lf;
                }
                else {
                    ans+= lf*lf+ lt*lt;
                }
            }
        }
        return mat[i][j][isTrue]=ans;
    }
}
