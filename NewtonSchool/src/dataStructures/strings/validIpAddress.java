package dataStructures.strings;

/*
Write a program to Validate an IPv4 Address.
According to Wikipedia, IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1 .
A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255.
Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255).
Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.

Your task is to complete the function isValid which returns 1 if the given IPv4 address is valid else returns 0. The function takes the IPv4 address as the only argument in the form of string.

Example 1:

Input:
IPv4 address = 222.111.111.111
Output: 1
Explanation: Here, the IPv4 address is as
per the criteria mentioned and also all
four decimal numbers lies in the mentioned
range.
 */
public class validIpAddress {
    public static boolean isValid(String str){
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='.'){
                count++;
            }
        }
        if(count!=3){
            return false;
        }
        String[] ip= str.split("\\.");
        //System.out.println(Arrays.toString(ip));
        if(ip.length!=4){
            return false;
        }
        for (int i = 0; i < ip.length; i++) {
            int j=0;
            if(ip[i].length()==0){
                return false;
            }
            while (j<ip[i].length()){
                if(ip[i].charAt(j)<'0'|| ip[i].charAt(j)>'9' ){
                    return false;
                }
            }
            if(ip[i].length()>1 && ip[i].charAt(0)=='0') {
                return false;
            }

//            if(!validIpAddress.isNumeric(ip[i])){
//                return false;
//            }

            int num =Integer.parseInt(ip[i]);
            if(num <0 || num >255){
                return false;
            }
        }
        return true;

    }
//    public static boolean isNumeric(String str) {
//        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
//    }

    public static void main(String[] args) {
        String str="0.0.0.0.";
        System.out.println(isValid(str));
    }
}
