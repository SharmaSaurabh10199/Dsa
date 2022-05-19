package contests;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class levelOrder {
    public static void main (String[] args) {
        // Your code here
        Scanner s= new Scanner(System.in);
        int n =  s.nextInt();
        int[] left= new int[n+1];
        int[] right= new int[n+1];
        for(int i=1; i<=n; i++){
            left[i]=s.nextInt();
            right[i]=s.nextInt();
        }
        printnodeCount(left,right,n);
    }
   static  public void printnodeCount(int[] left, int[] right, int querie){
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        int d=0;
        while (!q.isEmpty()){
            int n= q.size();
            System.out.println(n+" ");
            d++;
            for (int i = 0; i < n; i++) {
                int curr= q.poll();
                if(left[curr]!=-1){
                    q.add(left[curr]);
                }
                if(right[curr]!=-1){
                    q.add(right[curr]);
                }
            }
        }
        while (d<= querie){
            System.out.print(0+" ");
        }
    }

}
