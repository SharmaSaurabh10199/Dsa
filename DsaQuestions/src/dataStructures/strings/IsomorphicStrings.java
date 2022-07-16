package dataStructures.strings;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        HashMap<Character,Integer> hm= new HashMap<>();
        System.out.println(hm.get(3)!=0);
    }
    public boolean isIsomorphic(String str1, String str2){
        // hashmap should not be used here cus that will give the null pointer exception
        char[] map1= new char[256];
        char[] map2= new char[256];
        if(str1.length()!=str2.length()){
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            char ch1= str1.charAt(i);
            char ch2= str2.charAt(i);
            if(map1[ch1]==0 && map2[ch2]==0){
                map1[ch1]=ch2;
                map2[ch2]=ch1;
            }
            else {
                if(map1[ch1]!=ch2){
                    return false;
                }
            }
        }
        return true;
    }
}
