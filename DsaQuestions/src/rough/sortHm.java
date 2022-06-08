package rough;

import java.util.*;

public class sortHm {
    public static void sortHm(String str){
        HashMap<Character,Integer> hm= new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list= new ArrayList<Map.Entry<Character,Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue()==o2.getValue()){
                    return o2.getKey()-o1.getKey();
                }
                return o2.getValue()-o1.getValue();
            }
        });
        System.out.println(list.get(2).getKey());
    }

    public static void main(String[] args) {
        sortHm("aaaabbbbccdef");
    }
}
