package algorithms.dp.inClass;
// Write the program to find the value for Nth Catalan Number. Given that C0 = C1 = 1.

// Example: N = 4
// O/P -> C4 = C0C3 + C1C2 + C2C1 + C3C0

// Ex: N = 2
// O/P -> C2 = C0C1 + C1C0

// Ex: N = 2
// O/P -> C3 = C0C2 + C1C1 + C2C0

// N = 5
// O/P -> C5 = C0C4 + C1C3 + C2C2 + C3C1 + C4C0

// -->there will be 2 for loops here, dp[n] is dependent on dp[0] to dp[n-1] in a new way every time.
public class CatalanNo {
    int nthCatalanNo(int n){
        int[] dp= new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]+= dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
