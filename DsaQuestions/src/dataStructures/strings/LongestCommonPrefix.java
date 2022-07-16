package dataStructures.strings;
/*
Given a array of N strings, find the longest common prefix among all strings present in the array.


Example 1:

Input:
N = 4
arr[] = {geeksforgeeks, geeks, geek,
         geezer}
Output: gee
Explanation: "gee" is the longest common
prefix in all the given strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr={"abab","aba",""};
        System.out.println(longestPrefix(arr));
    }
    // efficient one.
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    public static String longestPrefix(String[] arr, int N){
        StringBuilder prev= new StringBuilder(arr[0]);
        StringBuilder res= new StringBuilder();
        for (int i = 1; i <N; i++) {
            String curr= arr[i];
            res= new StringBuilder("");
            for (int j = 0; j < curr.length() && j<prev.length(); j++) {
                if(curr.charAt(j)==prev.charAt(j)) {
                    res.append(curr.charAt(j));
                }
              else {
                  break;
                }
            }
            prev=res;
        }
        // .equals is not working here?
        if(prev.length()==0){
            return "-1";
        }
        return prev.toString();
    }
    public static String longestPrefix(String[] arr){
        String res= arr[0];
        int N=arr.length;
        for (int i = 1; i <N; i++) {
            String curr= arr[i];
            if(curr.length()==0){
                return "1";
            }
            //res= new StringBuilder("");
            for (int j = 0; j < curr.length() && j<res.length(); j++) {
                if( curr.charAt(j)!=res.charAt(j)  ) {
                    //res.append(curr.charAt(j));
                    res=res.substring(0,j);
                    break;
                }
                else if(j==curr.length()-1 || j==res.length()-1){
                    res=res.substring(0,j+1);
                }
            }
            if(res.length()==0){
                break;
            }

        }
        System.out.println(res.length());
        // .equals is not working here?
//        if(prev.length()==0){
//            return "-1";
//        }
        return res;
    }
}
