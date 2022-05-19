package algorithms.recursion.strings;

public class removeAdjDuplicates {
    static String removeDuplicates(String str, int index, String res){
        if(index==str.length()-1){
            res+=str.charAt(index);
            return res;
        }
        if(str.charAt(index)!=str.charAt(index+1)){
            res+=str.charAt(index);
        }
        return removeDuplicates(str,index+1,res);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaaa",0,""));
    }
}
