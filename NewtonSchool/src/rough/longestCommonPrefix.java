package rough;

import java.util.HashMap;
import java.util.Map;

public class longestCommonPrefix {
    public String result(String[] arr){
        String str=arr[0];
        for (int i = 0; i < arr.length; i++) {
            while (arr[i].indexOf(str)!=0){
                str=str.substring(0,str.length()-1);
                if(str.isEmpty()){
                    return "";
                }
            }
        }
        return str;
    }
    public static void playingAroundWithhm(){
        HashMap<String,Integer> hm= new HashMap<>();
        hm.put("karishan",1);
        hm.put("harru",2);
        hm.put("sonu",3);
        for (Map.Entry<String,Integer> item: hm.entrySet()){
            System.out.println(item.getKey());
        }

    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm= new HashMap<>();
        hm.put("karishan",1);
        hm.put("harru",2);
        hm.put("sonu",3);
        int max=0;
        for (Map.Entry<String,Integer> item: hm.entrySet()){
            //System.out.println(item.getKey());
            String str=item.getKey();
            int a= item.getValue();
            if(max<a){
                max=a;
            }
        }
    }
}
