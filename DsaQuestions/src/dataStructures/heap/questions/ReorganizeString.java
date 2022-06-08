package dataStructures.heap.questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.



Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 */
public class ReorganizeString {
    class pair{
        int x;
        char ch;
        public pair(char ch, int x){
            this.x=x;
            this.ch=ch;
        }
    }
    class pairSort implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            return o2.x-o1.x;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder str= new StringBuilder();

        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<pair> pq= new PriorityQueue<>(new pairSort());
        for (Map.Entry<Character,Integer> item:
             hm.entrySet()) {
            pq.add(new pair(item.getKey(),item.getValue()));
        }
        pair prev= new pair('#',-1);
        while (!pq.isEmpty()){
            pair curr= pq.poll();
            str.append(curr.ch);
            curr.x--;
            if(prev.x>0){
                pq.add(prev);
            }
            prev=curr;
        }
        if(str.length()==s.length()){
            return str.toString();
        }
        return "";
    }

}
