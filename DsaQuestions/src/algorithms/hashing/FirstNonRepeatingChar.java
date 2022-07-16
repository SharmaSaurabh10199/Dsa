package algorithms.hashing;
/*
given a non empty string, you have to find the first non repeating character.
 */
import java.util.HashMap;
import java.util.Set;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str="newtonSchool";
       // Scanner s= new Scanner(System.in);
      //  String str= s.next();


        System.out.println(firstNonRepeating(str));;
    }
    static int firstNonRepeating(String s){
        HashMap<Character,Integer> hm= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        //System.out.println(hm);
        Set set= hm.entrySet();
        System.out.println(set);
        for (int i = 0; i < s.length(); i++) {
            if(hm.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
