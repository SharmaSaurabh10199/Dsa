package dataStructures.strings;
/*
Given an integer n. Return the nth row of the following look-and-say pattern.
1
11
21
1211
111221
Look-and-Say Pattern:

To generate a member of the sequence from the previous member, read off the digits of the previous member, counting the number of digits in groups of the same digit. For example:

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
1211 is read off as "one 1, one 2, then two 1s" or 111221.
111221 is read off as "three 1s, two 2s, then one 1" or 312211.
 */
public class patternMatch {
    static String lookandsay(int n) {
        //your code here
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        String str="11";
        for (int i = 3; i <=n ; i++) {
            String temp="";
            str+="@";
            StringBuilder sb= new StringBuilder();
            int count=1;
            for (int j = 1; j < str.length(); j++) {
                if(str.charAt(j)!=str.charAt(j-1)){
                    temp+=count;
                    temp+=str.charAt(j-1);
                    count=1;
                }
                else {
                    count++;
                }
            }
            str=temp;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(lookandsay(5));
    }
}
