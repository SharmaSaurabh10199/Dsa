package dataStructures.stacks.inClass;

import java.util.Arrays;
import java.util.Stack;

public class postfixToInfix {
    public static void postToInfix(String str){
        Stack<String> st= new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            if(Character.isLetter(c)){
                st.push(c+"");
            }
            else {
                String a= st.pop();
                String b= st.pop();
                st.push("("+b+c+a+")");
            }
        }
        System.out.println(st.peek());
    }

    public static void main(String[] args) {
//         InfixtoPostFix obj1= new InfixtoPostFix();
//         obj1.intoPost("a+b*(c^d-e)^(f+g*h)-i");
//        //String str="ab*c+";
//        Scanner s= new Scanner(System.in);
//        String str= s.next();
//       // abcd^e-fgh*+^*+i-
//        //postToInfix(str);
//        prefixToInFix obj= new prefixToInFix();
//        obj.preToIn("*-A/BC-/AKL");
        postFixEval ob= new postFixEval();
        ob.evalPostFix("4 13 5 / +");
    }
}
class prefixToInFix{
    public void preToIn(String str){
        Stack<String> st= new Stack<>();
        for (int i = str.length()-1; i >=0; i--) {
            char c= str.charAt(i);
            if(Character.isLetter(c)){
                st.push(Character.toString(c));
            }
            else {
                String a= st.pop();
                String b= st.pop();
                st.push("("+a+c+b+")");
            }
        }
        System.out.println(st.peek());
    }
}
class InfixtoPostFix{
    public void intoPost(String str){
        Stack<Character> st= new Stack<>();
        String res="";
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            if(Character.isLetter(c)){
                res+=c;
            }
            else {
                if(c=='('){
                    st.push(c);
                }
                else if(c==')'){
                    while (!st.isEmpty() &&st.peek()!='('){
                        res+=st.pop();
                    }
                    if(!st.isEmpty()){
                        st.pop();
                    }
                }
                else {
                    while (!st.isEmpty() &&priority(st.peek())>=priority(c)){
                        res+=st.pop();
                    }
                    st.push(c);
                }
            }
        }
        while (!st.isEmpty()){
            res+=st.pop();
        }
        System.out.println(res);
    }
    public int priority(char c){
        if(c=='+'|| c=='-'){
            return 1;
        }
        else if(c=='*'|| c=='/'){
            return 2;
        }
        else if(c=='^'){
            return 3;
        }
        return 0;
    }
}
class postFixEval{
    public void evalPostFix(String str){
        Stack<Integer> st= new Stack<>();
        String arr[]=str.split("\\s");
        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i <str.length(); i++) {
//            //char c= str.charAt(i);
//            if(str.charAt(i)==' '){
//                continue;
//            }
//            else if(Character.isDigit(str.charAt(i))){
//                //st.push(Character.getNumericValue(c));
//                StringBuffer sbuf = new StringBuffer();
//                while (i<str.length() && Character.isDigit(str.charAt(i))){
//                    sbuf.append(str.charAt(i));
//                    i++;
//                }
//                st.push(Integer.parseInt(sbuf.toString()));
//                i--;
//            }
//            else {
//                int b= st.pop();
//                int a= st.pop();
//                int res= Compute(str.charAt(i),a,b);
//                st.push(res);
//            }
//        }
        //System.out.println(st.peek());
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("+")|| arr[i].equals("*")|| arr[i].equals("/")|| arr[i].equals("-") ){
                int b= st.pop();
                int a= st.pop();
                int res= Compute(arr[i],a,b);
                st.push(res);
            }
            else {
                st.push(Integer.parseInt(arr[i]));
            }
        }
        System.out.println(st.peek());
    }
    public int Compute(String c, int a, int b)
    {
        if(c.equals("+"))
            return a+b;
        else if(c.equals("-"))
            return a-b;
        else if(c.equals("*"))
            return a*b;
        else if(c.equals("/"))
        return a/b;
        return -1;
    }

}
