package dataStructures.strings;

/*
Your task  is to implement the function atoi. The function takes a string(str) as argument and converts 
it to an integer and returns it.

Note: You are not allowed to use inbuilt function.

Example 1:

Input:
str = 123
Output: 123
Example 2:

Input:
str = 21a
Output: -1
Explanation: Output is -1 as all
characters are not digit only.
 */
public class atoi {
    public static int convertStrTiInt(String str) {
        int num = 0;
        boolean positive = true;
        int i = 0;
        if (str.charAt(0) == '-') {
            positive = false;
            i++;
        }
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return -1;
            }
            int digit = str.charAt(i) - '0';
            num += digit * Math.pow(10, str.length() - 1 - i);
            i++;
        }
        if (!positive) {
            return -num;
        }
        return num;
    }

    public static void main(String[] args) {
        String str = "-12";
        System.out.println(convertStrTiInt(str));
    }
}
