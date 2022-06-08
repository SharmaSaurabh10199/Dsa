package contests;

import java.util.Scanner;

public class MinTime {
    public static int minIteration(int n){
        if(n<=1){
            return 0;
        }
        boolean flag=true;
        int x=1,y=1;
        int count=0;
        while (true){
            if(flag){
                x=x+y;
                flag=false;
            }
            else {
                y=x+y;
                flag=true;
            }
            count++;
            if(x==n || y==n){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();

        System.out.println(minIteration(n));
    }
}
