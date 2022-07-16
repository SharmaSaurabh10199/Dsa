package contests;

public class ways {
    public boolean ispossible(long[][] mat, int n, int m){
        if(n==1 && m==1){
            return true;
        }
        if(mat[0][0]!=mat[n-1][m-1]){
            return false;
        }
        long max=mat[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(max<mat[i][j]){
                    return false;
                }
            }
        }
        return false;
    }
}
