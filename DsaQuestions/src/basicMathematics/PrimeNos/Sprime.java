package basicMathematics.PrimeNos;

import java.util.Scanner;

//Sara has developed a new algorithm to find sprime for a given range starting with 2
//
//She will start from the end mark it sprime, and mark all its factors (excluding itself) as not sprime. Then she will find the next greatest unmarked number, mark it as sprime, and mark all its factors (excluding itself) as not sprime
//
//Your task is to calculate the the number of sprimes that are actually prime
//Input
//The first line contains T the number of test cases.
//Each of the next T lines contain an integer n.
//
//Constraint:-
//1 <= T <= 100
//2 <= n <= 10000000
//Output
//Output T lines, one for each test case, containing the required answer.
public class Sprime {
    static int max=10000000;
    static int[] arr = new int[max+1];
    public static void main(String[] args) {
        sieve();
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int k = 0; k < t; k++) {
            int n = s.nextInt();
            System.out.println(countRes(n));
        }
    }
    public static void  sieve() {
        for (int i = 2; i * i <= max; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= max; j += i) {
                    arr[j] = 1;
                }
            }
        }

    }
    public static int countRes(int n){
        int count=0;
        int start= n/2+1;
        for (int i = start; i <=n ; i++) {
            if(arr[i]==0){
                count++;
            }
        }
        return count;
    }

}
