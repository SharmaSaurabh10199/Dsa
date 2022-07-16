package contests;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortWords {
    static void sortWords(String str){
        String[] s= str.split(" ");
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]+" ");
//        }
        Arrays.sort(s);
        System.out.println(s.length);


        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }

    public static void main(String[] args) {
//        String str= "i am a rockstar developer";
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        sortWords(str);
    }
}
