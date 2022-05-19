package algorithms.slidingWindow.variableWindow;

import java.util.HashMap;

/*
Given two strings, string1 and string2, the task is to find the smallest substring in string1 containing all
 characters of string2 efficiently.

 Input: string = “this is a test string”, pattern = “tist”
Output: Minimum window is “t stri”
 */
public class MinimunWindowSubstr {
    static int miniWindow(String str,String pat){
        int i=0,j=0,k=0,min=Integer.MAX_VALUE;
        int start=0;
        String res="-1";
        HashMap<Character,Integer> hm= new HashMap<>();
        while (k<pat.length()){
            char chk =pat.charAt(k);
            if(hm.containsKey(chk)){
                hm.put(chk,hm.get(chk)+1);
            }
            else {
                hm.put(chk,1);
            }
            k++;
        }
        int count=hm.size();
        while (j<str.length()){
            char chj=str.charAt(j);
            if(hm.containsKey(chj)){
                hm.put(chj,hm.get(chj)-1);
                if(hm.get(chj)==0){
                    count--;
                }
            }
            if(count>0){
                j++;
            }
            else if(count==0){
                while (count==0){
                    //min=Math.min(min,j-i+1);
                    if(min>j-i+1){
                        min=j-i+1;
                        start=i;
                    }
                    //res=str.substring(i,j+1);
                    //System.out.print(res+" ");
                    char chi=str.charAt(i);
                    if(hm.containsKey(chi)){
                        hm.put(chi,hm.get(chi)+1);
                        if(hm.get(chi)==1){
                            count++;
                        }
                    }
                    i++;
                }
                j++;
            }

        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        res=String.valueOf(str).substring(start, min+start);
        System.out.println(res);
        return min;
    }

    public static void main(String[] args) {
        String str="timetopractice";
        String pat="toc";
        System.out.println(miniWindow(str,pat));
    }
}
