package mockInterviews;
/*
Input: {"geeksforgeeks", "geeks", "geek", "geezer"}
Output: "gee"
 */
public class longestCommonPrefix {
    public static String longestPrefix(String[] arr){
        String prefix=arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "-1";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr=  {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestPrefix(arr));
    }
}
