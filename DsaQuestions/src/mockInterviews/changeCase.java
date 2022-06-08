package mockInterviews;
// my name is saurabh:
// My Name Is Saurabh
public class changeCase {
    public static void changeCases(String str){
        String res="";
        if(str.charAt(0)>='a' && str.charAt(0)<='z'){
            res+=(char)(str.charAt(0)-'a'+'A');
        }
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i-1)==' ' && (str.charAt(i)>='a' && str.charAt(i)<='z')){
                res+=(char)(str.charAt(i)-'a'+'A');
            }
            else{
                res+=str.charAt(i);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        changeCases("my name is saurabh");
    }
}
