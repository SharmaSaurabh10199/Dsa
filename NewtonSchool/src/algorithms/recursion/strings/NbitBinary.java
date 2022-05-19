package algorithms.recursion.strings;

import java.util.ArrayList;

public class NbitBinary {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> list= new ArrayList<>();
        int one=0,zero=0;
        String op="";
        result(list,op,one,zero,N);
        return list;

    }
    public void result(ArrayList<String> list,String op,int one, int zero,int n){
        if(n==0){
            list.add(op);
            return;
        }
        if(one>zero){
            String op1=op+"1";
            String op2=op+"0";
            result(list,op1,one+1,zero,n-1);
            result(list,op2,one,zero+1,n-1);
        }
        else{
            String op3=op+"1";
            result(list,op3,one+1,zero,n-1);
        }
    }
}
