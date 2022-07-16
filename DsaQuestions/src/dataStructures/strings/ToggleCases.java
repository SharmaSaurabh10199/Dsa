package dataStructures.strings;
/*
You are given a string and your task is to swap cases. In other words, convert all lowercase letters
to uppercase letters and vice versa.

For Example:

Www.HackerRank.com → wWW.hACKERrANK.COM
Pythonist 2 → pYTHONIST 2
 */
/*
Some important notes about type conversions:
  1) if you store int value in char, its gona store the character in that index which is in ascii.
  2) the operations performed on char, like sum and subtraction, are actually performed on the index
  ascii values and the results are those char at ascii values;
 */
public class ToggleCases {
    public static void main(String[] args) {
//        char check= 'b'+'a';
//        char ch= (char) 100000;
//        System.out.println(ch);
//        System.out.println((int)check);
        String s1="saurabh";
        String s2="saurabh";
        System.out.println(s2==s1);
        s1.concat("sharma");
        System.out.println(s2==s1);
        System.out.println(s2);

//        String s= "HackerRank.com presents Pythonist 2";
//        toggleCaes(s);
    }
    public static void toggleCaes(String s){
        StringBuilder res= new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr=s.charAt(i);
            if(curr>='a' && curr<='z'){
                curr= (char) (curr+'A'-'a');
                res.append(curr);
            }
            else if(curr>='A'&& curr<='Z'){
                curr= (char) (curr-'A'+'a');
                res.append(curr);
            }
            else {
                res.append(curr);
            }
        }
        System.out.println(res);
    }
}
