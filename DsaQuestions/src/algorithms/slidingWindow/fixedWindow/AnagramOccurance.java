package algorithms.slidingWindow.fixedWindow;

import java.util.HashMap;

/*
Given a word and a text, return the count of the occurrences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))

Examples:

Input : forxxorfxdofr
        for
Output : 3
Explanation : Anagrams of the word for - for, orf,
ofr appear in the text and hence the count is 3.
 */
public class AnagramOccurance {
    static int countAnagrams(String str,String subStr){
        HashMap<Character,Integer> hm= new HashMap<>();
        for (int i = 0; i < subStr.length(); i++) {
            hm.put(subStr.charAt(i),hm.getOrDefault(subStr.charAt(i),0)+1);
        }
        int i=0,j=0,count=hm.size(),ans=0;
        while (j<str.length()){
            char c=str.charAt(j);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0){ // important
                    count--;
                }
            }
            if(j-i+1<subStr.length()){
                j++;
            }
            else if(j-i+1==subStr.length()){
                if(count==0){
                    ans++;
                }
                char ch=str.charAt(i);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)+1);
                    if(hm.get(ch)==1){ // important
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str="forxxorfxdofr";
        String subStr="for";
        System.out.println(countAnagrams(str,subStr));
    }
}
