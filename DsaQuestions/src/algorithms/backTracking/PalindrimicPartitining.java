package algorithms.backTracking;

import java.util.ArrayList;

/*
Given a String S, Find all possible Palindromic partitions of the given String.


Example 1:

Input:
S = "geeks"
Output:
g e e k s
g ee k s
Explanation:
All possible palindromic partitions
are printed.
 */
public class PalindrimicPartitining {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> res= new ArrayList<>();
        ArrayList<String> sublist= new ArrayList<>();
        solve(S,0,sublist,res);
        return res;

    }
    static void solve(String str, int index, ArrayList<String> sublist, ArrayList<ArrayList<String>> res){
        if(index==str.length()){
            res.add(new ArrayList<>(sublist));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if(isPalindrome(str.substring(index,i+1))){
                sublist.add(str.substring(index,i+1));
                solve(str,i+1,sublist,res);
                sublist.remove(sublist.size()-1);
            }
        }
    }
    static boolean isPalindrome(String str){
        int star= 0;
        int end= str.length()-1;
        while (star<end){
            if(str.charAt(star++)!=str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(allPalindromicPerms("geeks"));
        // the output of this is interesting, removing form the temp also removes from the res which already has temp added.
        // that is why we had to made a new list in base case;
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        ArrayList<Integer> temp= new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        res.add(temp);
        temp.remove(temp.size()-1);
        System.out.println(res);
        System.out.println(temp);
    }
}
