package basicMathematics.PrimeNos;

import java.util.ArrayList;
import java.util.Scanner;

/*

Let's define P[i] as the ith Prime Number. Therefore, P[1]=2, P[2]=3, P[3]=5, so on.
Given two integers L, R (L<=R), find the value of P[L]+P[L+1]+P[L+2]...+P[R].
Input
The first line of the input contains an integer T denoting the number of test cases.
The next T lines contain two integers L and R.

Constraints
1 <= T <= 50000
1 <= L <= R <= 50000

 */
public class FirstNprimeNos {
     static ArrayList<Integer> list=new ArrayList<>();
     static ArrayList<Long> list1=new ArrayList<>();
    public static void main(String[] args) {
        sieve();
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int k = 0; k < t; k++) {
            int l = s.nextInt();
            int r = s.nextInt();
            System.out.println(res(l, r));

        }


    }


    public static void  sieve() {
        int max = 700000;
        long sum = 0;
        int[] arr = new int[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= max; j += i) {
                    arr[j] = 1;
                }
            }
        }
        for (int i = 2; i <=max; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {

            list1.add(sum);
            sum += list.get(i);
        }
        list1.add(sum);



    }
    public static long  res(int l,int r){

       long res= list1.get(r)-list1.get(l-1);
       // System.out.println(list.size());
        return res;
    }
}
