package mockInterviews;

import java.util.Arrays;

public class kanpSack01 {
    static int  solve(int[] values, int[] weight, int c, int n,int[][] t){
        if(n==0 || c==0){
            return 0;
        }
        if(t[n][c]!=-1){
            return t[n][c];
        }
        if(weight[n-1]>c){
            return t[n][c]= solve(values,weight,c,n-1,t);
        }
        else {
            return t[n][c]= Math.max((values[n-1]+ solve(values,weight,c-weight[n-1],n-1,t)),solve(values,weight,c,n-1,t));
        }
    }
    static public int kanpSack(int[] v, int[] w, int c){
        int[][] t= new int[w.length+1][c+1];
        for(int[] a: t){
            Arrays.fill(a,-1);
        }

        //return t[w.length][c];
        return solve(v,w,c,w.length,t);
    }

    public static void main(String[] args) {
       int[] Weights={3, 4, 6, 5};

       int[] Profits= {2, 3, 1, 4};
       int weight=8;
        System.out.println(kanpSack(Profits,Weights,weight));

    }
}
