package dataStructures.stacks.inClass;

import java.util.Scanner;
import java.util.Stack;

public class restrictiveCandyCrush {
    class pair{
        char c;
        int count;
        public pair(char  c, int n){
            this.c=c;
            this.count=n;
        }
    }
    public String modify(String str, int k){
        StringBuilder res= new StringBuilder("");
        if(k==1){
            return res.toString();
        }
        Stack<pair> st= new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(st.isEmpty()){
                st.push(new pair(str.charAt(i),1));
            }
            else if(st.peek().c==str.charAt(i)){
                st.peek().count+=1;
                if(st.peek().count==k){
                    st.pop();
                    //continue;
                }

            }
            else {
                st.push(new pair(str.charAt(i),1));
            }
        }
        while (!st.isEmpty()){
           char c= st.peek().c;
           int cnt=st.peek().count;
           while (cnt>0){
               res.append(c);
               cnt--;
           }
           st.pop();
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str= s.next();
        restrictiveCandyCrush r= new restrictiveCandyCrush();
        System.out.println(r.modify(str,2));
    }
}
