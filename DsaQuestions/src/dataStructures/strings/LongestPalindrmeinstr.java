package dataStructures.strings;

/*

Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).


Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
 */
/*
  solution:
     steps 1): take 2 cases for even and odd, maintain 2 pointers.
           2): check if value of low and high are equal, update start to the low
              and store the lenght of the current substring if it is greater then previous
              stored length;
 */
public class LongestPalindrmeinstr {
    static String longestPalin(String S) {
        int start = 0, end = 1;
        for (int i = 1; i < S.length(); i++) {
            int l = i - 1;
            int h = i;
            while (l >= 0 && h < S.length() && S.charAt(l) == S.charAt(h)) {
                if (h - l + 1 > end) {
                    start = l;
                    end = h - l + 1;
                }
                l--;
                h++;
            }
            l = i - 1;
            h = i + 1;
            while (l >= 0 && h < S.length() && S.charAt(l) == S.charAt(h)) {
                if (h - l + 1 > end) {
                    start = l;
                    end = h - l + 1;
                }
                l--;
                h++;
            }

        }
        return S.substring(start,start+end);


    }

    public static void main(String[] args) {
        System.out.println(longestPalin("aaaabbaa"));
    }

}
