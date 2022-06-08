package assignments.jan19;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ques1 {
    public static void main(String[] args) {
//        result(30,2);
//        System.out.println(set);
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int k = 0; k < t; k++) {
            int a = s.nextInt();
            int b = s.nextInt();
            Set<Integer> set= new HashSet<>();
            set.add(a);
            result(set,a,b);
            System.out.println(set.size());
        }
    }
    public static void result(Set set,int a, int b){
        if(b==0){
            return;
        }
        set.add(a+3);
        set.add(a-3);
        set.add(a*2);
        result(set,a+3,b-1);
        result(set,a-3,b-1);
        result(set,a*2,b-1);
    }
}
