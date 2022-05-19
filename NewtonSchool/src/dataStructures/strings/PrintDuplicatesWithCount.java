package dataStructures.strings;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicatesWithCount {
    static public void printDuplicates(String str){
        HashMap<Character,Integer> hm= new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> item: hm.entrySet()){
            if(item.getValue()>1){
                System.out.println("key: "+item.getKey()+" value: "+item.getValue());
            }
        }
    }

    public static void main(String[] args) {
        printDuplicates("aaabbccdd");
    }
}
