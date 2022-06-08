package rough;

import java.util.ArrayList;
import java.util.Deque;

public class Dequeue {
    public static void main(String[] args) {
        String s=null;
        String s1=s;
//        System.out.println(s1.);
        Deque<Integer> dq= (Deque<Integer>) new ArrayList<Integer>();
        if(dq.isEmpty()){
            System.out.println("-1");
        }
        else{
            dq.removeLast();
        }
    }

}
