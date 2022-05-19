package algorithms.recursion.strings;

import java.util.HashSet;
import java.util.Set;

public class SubSetsOfString {
    public static void printSubSets(String op, String ip){
        if(ip.length()==0){
            System.out.print(op+" ");
            return;
        }
        String op1=op;
        String op2=op+ip.charAt(0);
        String newIp=ip.substring(1);
        printSubSets(op1,newIp);
        printSubSets(op2,newIp);
    }

    public static void main(String[] args) {
        printSubSets("","abc");


    }
}
class uniqueSubSetsOfString{
    static Set<String > set= new HashSet<>();
    public static void uniqueSubSets(String op, String ip){
        if(ip.length()==0){
            set.add(op);
            return;
        }
        String op1=op;
        String op2=op+ip.charAt(0);
        String newIp=ip.substring(1);
        uniqueSubSets(op1,newIp);
        uniqueSubSets(op2,newIp);
    }

    public static void main(String[] args) {
        uniqueSubSets("","aab");
        System.out.println(set);
    }
}