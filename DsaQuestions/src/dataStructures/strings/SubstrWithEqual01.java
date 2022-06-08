package dataStructures.strings;

import java.util.HashMap;

public class SubstrWithEqual01 {
    public static void main(String[] args) {
        String str= "0111100010";
        System.out.println(maxSubStr(str));
    }

    public static int maxSubStr(String str) {
        //Write your code here
        int count0=0,count1=0;
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='0'){
                count0++;
            }
            else {
                count1++;
            }
            if(count0==count1){
                count++;
            }
        }
        if(count0!=count1){
            return -1;
        }
        return count;
    }

}
