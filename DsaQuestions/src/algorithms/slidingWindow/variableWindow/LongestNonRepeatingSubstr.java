package algorithms.slidingWindow.variableWindow;

import java.util.HashMap;

public class LongestNonRepeatingSubstr {
    static int longestUniqueCharSubstr(String str){
        int i=0,j=0,ans=0;
        HashMap<Character,Integer> hm= new HashMap<>();
        while (j<str.length()){
            char chj=str.charAt(j);
            if(hm.containsKey(chj)){
                hm.put(chj,hm.get(chj)+1);
            }
            else {
                hm.put(chj,1);
            }
            if(hm.size()==j-i+1){
                ans=Math.max(ans,hm.size());
                j++;
            }
            else if(hm.size()<j-i+1){
                while (hm.size()<j-i+1){
                    char chi=str.charAt(i);
                    hm.put(chi,hm.get(chi)-1);
                    if(hm.get(chi)==0){
                        hm.remove(chi);
                    }
                    i++;
                }
                // one possible result lie here, but this value will always be samller than stored so this will not make
                // that big diff.
                j++;
            }

        }
        return ans;
    }
}
