package algorithms.slidingWindow.variableWindow;

import java.util.HashMap;

public class LongestSubstrWithKuniquwChar {
    static int result(String str, int k){
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
            if(hm.size()<k){
                j++;
            }
            else if(hm.size()==k){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else if(hm.size()>k){
                while (hm.size()>k){
                    char chi=str.charAt(i);
                    hm.put(chi,hm.get(chi)-1);
                    if(hm.get(chi)==0){
                        hm.remove(chi);
                    }
                    i++;
                }
                // we can store one result here too as thr loop might stop when hm.size==k. whe  it stops for hmsize<k,
                // then first condition takes care of it.
                if(hm.size()==k){
                    ans=Math.max(ans,j-i+1);
                   // store the possble result and then proceed
                }
                j++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String str="aabacbebebe";
        System.out.println(result(str,3));
    }
}
