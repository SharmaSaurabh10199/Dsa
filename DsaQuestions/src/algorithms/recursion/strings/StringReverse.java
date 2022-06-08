package algorithms.recursion.strings;

public class StringReverse {
    public static String reverse(String str){
        if(str.equals("")){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("sonu"));
    }
}
