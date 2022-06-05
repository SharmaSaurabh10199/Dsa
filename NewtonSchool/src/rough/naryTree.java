package rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class naryTree {
    static void NaryTree(long number){
        long[] start= new long[100];
        long[] end= new long[100];
        start[1]=1;
        end[1]=1;
        int j=0;
        ArrayList<Long> res= new ArrayList<>();
        for (int i = 2; i < 100; i++) {
            if(start[i-1]>number){
                j=i-2;
                break;
            }
            start[i]=end[i-1]+1;
            int level= i%2==1? 4: 2;
            end[i]=end[i-1]+(end[i-1]-start[i-1]+1)*level;
        }
        System.out.print(Arrays.toString(start));
        System.out.print(Arrays.toString(end));

        long curr= number;
        while (j>1){
            res.add(curr);
            long diff= curr-start[j];
            int level= j%2==1? 4: 2;
            long move=  (diff/level);
            curr= start[j-1]+move;
            j--;
        }
        res.add(1L);
        for (int i = res.size()-1; i >=0 ; i--) {
            System.out.print(res.get(i)+" ");
        }

    }

    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        long l= sc.nextLong();
        NaryTree(14);
    }
}
