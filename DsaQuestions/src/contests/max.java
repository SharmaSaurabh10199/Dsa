package contests;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class max {
    static void maxValue(int[] arr, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        long sum=0;
        while (!pq.isEmpty()){
            sum+=pq.poll();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int k= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        maxValue(arr,k);
    }
}
