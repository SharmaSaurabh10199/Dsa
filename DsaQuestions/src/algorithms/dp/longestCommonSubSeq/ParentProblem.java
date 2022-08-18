package algorithms.dp.longestCommonSubSeq;

// import java.util.Arrays;

public class ParentProblem {
    // memoization approach
    static int longestCommonSubSequence(String x, String y, int n, int m, int[][] t) {
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }
        if (t[n][m] != -1) {
            return t[n][m];
        }
        // choices
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return t[n][m] = 1 + longestCommonSubSequence(x, y, n - 1, m - 1, t);
        } else {
            // there are 2 further choices, we need to get the max of those choices
            return t[n][m] = Math.max(longestCommonSubSequence(x, y, n - 1, m, t),
                    longestCommonSubSequence(x, y, n, m - 1, t));
        }
    }

    // tabulation approach
    static int tabulationApproach(String x, String y, int n, int m, int[][] t) {
        // base condition
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n][m];
    }

    // driving function
    static public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] t = new int[n + 1][m + 1];
        // Arrays.fill method is used only for 1d arrays, we can't use it here
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                t[i][j] = -1;
            }
        }
        return tabulationApproach(text1, text2, n, m, t);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "acbdc"));

    }
}
