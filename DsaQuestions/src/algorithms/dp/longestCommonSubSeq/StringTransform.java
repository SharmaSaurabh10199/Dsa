package algorithms.dp.longestCommonSubSeq;

/*
Minimum number of deletions and insertions:
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2.
It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.


Example 1:

Input: str1 = "heap", str2 = "pea"
Output: 3
Explanation: 2 deletions and 1 insertion
p and h deleted from heap. Then, p is
inserted at the beginning One thing to
note, though p was required yet it was
removed/deleted first from its position
and then it is inserted to some other
position. Thus, p contributes one to the
deletion_count and one to the
insertion_count.


approach: the appraoch is very very simple, the no of insertions will be st2.lenght-lcs,
     the no of deletions will be st1.length-lcs.
     result will be the sum of both.

 */
public class StringTransform {

    public int minOperations(String str1, String str2) {
        // Your code goes here
        int[][] t = new int[str1.length() + 1][str2.length() + 1];
        int lcs = tabulationApproach(str1, str2, str1.length(), str2.length(), t);
        // the no of deletions:
        int deletions = str1.length() - lcs;
        // the no of insertions:
        int insertions = str2.length() - lcs;
        return insertions + deletions;

    }

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
}
