package dataStructures.strings;

import java.util.HashMap;

/*
Java Program to Check if a string is a valid shuffle of two distinct strings.
  given 2 strings, check if the 3rd string is valid string of str1+str2.

  solution:
  approach1: using anagrams
     steps 1) create a string temp=str1+str2,
           2) now check is str3 is anagram of temp
 */
public class validShuffle {
    public static boolean isValidShuffle(String str1, String str2, String str3){
        String temp= str1+str2;
        return isAnagram(temp,str3);
    }
    public static boolean isAnagram(String str, String str1){
        if(str1==null || str==null){
            return false;
        }
        if(str.length()!=str1.length()){
            return false;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }
        for (int i = 0; i < str1.length(); i++) {
            if(!hm.containsKey(str1.charAt(i))){
                return false;
            }
            hm.put(str1.charAt(i),hm.get(str1.charAt(i))-1);
            if(hm.get(str1.charAt(i))==0){
                hm.remove(str1.charAt(i));
            }
        }
        return hm.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidShuffle("bca","pqr","abcrq"));
    }
}
