package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class power {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int x= Integer.parseInt(inp.readLine());   // for taking a number as an input
        int n= Integer.parseInt(inp.readLine());
        int res= (int) (x*Math.pow(2
                ,n));
        System.out.println(res);

    }
}
