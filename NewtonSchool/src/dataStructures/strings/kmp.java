package dataStructures.strings;

import java.util.Arrays;

public class kmp {
    // prefix array brute force
    public static void prefixArray(String s){
        int n=s.length();
        int[] pi= new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.substring(0, j).equals(s.substring(i-j+1, i+1))){
                        pi[i] = j;
                }
            }
        }
        System.out.println(Arrays.toString(pi));
    }
    // unoptimised approach with time complexity o(mn)
    public boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
    // optimized prefix array
    public static int[] prefixArr(String str){
        int n=str.length();
        char[] ch= str.toCharArray();
        int[] pi= new int[n];
        pi[0]=0;
        int i=1,len=0;
        while (i<n){
            if(ch[len]==ch[i]){
                len++;
                pi[i]=len;
                i++;
            }
            else {
                if(len!=0){
                    len=pi[len-1];
                }
                else {
                    pi[i]=0;
                    i++;
                }
            }
        }
        //System.out.println(Arrays.toString(pi));
        return pi;
    }
    // kmp algorithm for pattern matching
    static boolean kmp(String text, String pattern){
        int[] lps= prefixArr(pattern);
        int i=0, j=0;
        while (i<text.length() && j<pattern.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i++; j++;
            }
            else {
                if(j!=0){
                    j=lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        if(j==pattern.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str="ababaca";
        prefixArr(str);
    }
}
