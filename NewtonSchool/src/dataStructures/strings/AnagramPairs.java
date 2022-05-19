package dataStructures.strings;

import java.util.HashMap;

public class AnagramPairs {
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
        System.out.println(isAnagram("eat","ate1"));
    }
}
