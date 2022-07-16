package algorithms.dp.mcm;

import java.util.Arrays;

/*
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome.


Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings
are "a", "babbbab", "b", "ababa".

--> approach:
         the approach is pretty much similar to mcm question here.
 */
public class PalindromicPartion {
    static int palindromicPartition(String str) {
        // code here
        int[][] t = new int[str.length() + 1][str.length() + 1];
        for(int[] a: t){
            Arrays.fill(a,-1);
        }
        System.out.println(Arrays.deepToString(t));
        return solve(str, 0, str.length() - 1, t);

    }

    static boolean isPalindrome(String str, int i, int j) {
        while (j > i) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int solve(String str, int i, int j, int[][] t) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(str, i, k, t) + solve(str, k + 1, j, t) + 1;
            if (min > temp) {
                min = temp;
            }
        }
        return t[i][j] = min;
    }

    public static void main(String[] args) {
        System.out.println(palindromicPartition("nitin"));
    }
}
