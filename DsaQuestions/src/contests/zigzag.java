package contests;

import java.util.HashSet;
import java.util.Set;

public class zigzag {
    public static void zigzag(int[] arr){
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println(set.size()-2);
    }
}
