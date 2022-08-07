package algorithms.hashing;

import java.util.HashSet;

/*
Given a string S, find the length of the longest substring without repeating characters.


Example 1:

Input:
S = "geeksforgeeks"
Output:
7
Explanation:
Longest substring is
"eksforg".
 */
public class LongestUniqueSubstring {
    static int longestUniqueSubsttr(String s){
        int max=1;
        HashSet<Character> set= new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                max=Math.max(set.size(),max);
            }
            else {
                set.clear();
                set.add(c);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        String s="geeksforgeeks";
        System.out.println(longestUniqueSubsttr(s));
    }

}
