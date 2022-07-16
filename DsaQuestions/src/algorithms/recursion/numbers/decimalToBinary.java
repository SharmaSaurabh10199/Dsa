package algorithms.recursion.numbers;

public class decimalToBinary {
    public static String binary(int n, String res){
        if(n==0){
            return reverse(res);
        }
        res+=n%2;
        return binary(n/2,res);
    }
    public static String reverse(String str){
        if(str.equals("")){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(binary(774758,""));
    }
}
