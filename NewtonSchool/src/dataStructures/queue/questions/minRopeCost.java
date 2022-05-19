package dataStructures.queue.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
You are given N ropes of L[i] lengths, you need to connect these ropes into one rope. The cost to connect
two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.
Sample Input:
2
4
4 3 2 6
5
4 2 7 6 9

Sample Output:
29
62
 */
public class minRopeCost {
    public static int minRopeCost(int[] arr, int n) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            res += first + second;
            pq.add(first + second);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
       // Scanner s = new Scanner(System.in);
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(inp.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(inp.readLine());
            int[] arr = new int[n];
            String line = inp.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(minRopeCost(arr,arr.length));
        }
    }
}
