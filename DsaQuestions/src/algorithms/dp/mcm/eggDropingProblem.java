package algorithms.dp.mcm;

import java.util.Arrays;

/*
You are given N identical eggs and you have access to a K-floored building from 1 to K.

There exists a floor f where 0 <= f <= K such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break. There are few rules given below.

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

For more description on this problem see wiki page

Example 1:

Input:
N = 1, K = 2
Output: 2
Explanation:
1. Drop the egg from floor 1. If it
   breaks, we know that f = 0.
2. Otherwise, drop the egg from floor 2.
   If it breaks, we know that f = 1.
3. If it does not break, then we know f = 2.
4. Hence, we need at minimum 2 moves to
   determine with certainty what the value of f is.
 */
public class eggDropingProblem {




    static int eggDrop(int e, int f)
    {
        // Your code here
        int[][] t= new int[e+1][f+1];
        for(int[] a: t){
            Arrays.fill(a,-1);
        }
        return solve(e,f,t);

    }
    static int solve(int e, int f, int[][] t){
        if(e==1 || f<=1){
            return f;
        }
        if(t[e][f]!=-1){
            return t[e][f];
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <=f; i++) {
            // max for the worst case
            int low=0,high=0;
            if(t[e-1][i-1]!=-1){
                low= t[e-1][i-1];
            }
            else {
                low= solve(e-1,i-1,t);
                t[e-1][i-1]=low;
            }
            if(t[e][f-i]!=-1){
                high=t[e][f-i];
            }
            else {
                high=solve(e,f-i,t);
                t[e][f-i]=high;
            }
            int temp=1+Math.max(low,high);
            if(min>temp){
                min=temp;
            }
        }
        return  t[e][f]= min;
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(4,3));
    }
}
