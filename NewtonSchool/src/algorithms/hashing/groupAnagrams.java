package algorithms.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        HashMap<String,List<String>> hm= new HashMap<>();
        for(String current: strs){
            char[] ch= current.toCharArray();
            Arrays.sort(ch);
            String s= new String(ch);
            if(!hm.containsKey(s)){
                hm.put(s,new ArrayList<String>());
            }
            hm.get(s).add(current);
        }
        res.addAll(hm.values());
        return res;
    }

}
