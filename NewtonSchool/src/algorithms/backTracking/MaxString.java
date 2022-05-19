package algorithms.backTracking;

import java.util.Scanner;

/*
Given a string S and an integer K, your task is to find the lexicographically maximum string after performing at most K swaps.
Sample Input:-
132
2

Sample Output:-
321

Sample Input:-
254
1

Sample Output:-
524
 */
public class MaxString {
    String max="";
    public void maxString(String str, int k){
        if(str.compareTo(max)>0){
            max=str;
        }

        if(k==0){
            System.out.println(str);
            return;
        }
        for(int i=0; i<str.length()-1; i++){
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(i)<str.charAt(j)){
                    str= swap(str,i,j);
                    maxString(str,k-1);
                    str=swap(str,i,j);
                }
            }
        }
    }
    // function to swap the numbers in string
    String  swap(String str, int i, int j){
        String first= str.substring(0,i);
        String middle= str.substring(i+1,j);
        String last= str.substring(j+1);
        return first+str.charAt(j)+ middle +str.charAt(i)+last;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();
        int k= sc.nextInt();
        MaxString obj= new MaxString();
        obj.maxString(str,k);
        System.out.println(obj.max);
    }

}
