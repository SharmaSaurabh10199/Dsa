package rough;

import java.util.Arrays;
import java.util.Scanner;

public class TileBreaker {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int m= s.nextInt();
        System.out.println(breakTile(n,m));
    }
    public static int breakTile(int n, int m){
        if(n%3==0 || m%3==0){
            return 0;
        }
        int[] arr= new int[3];
        int max= Math.max(m, n);
        int min= Math.min(m,n);
        int lt;
        if(max%3==2){
           lt=max/3+1;
        }
        else {
            lt=max/3;
        }
        arr[0]=lt*min;
        if(min%2==0|| (max-lt)%2==0){
            arr[1]= (min*(max-lt))/2;
            arr[2]=  (min*(max-lt))/2;

        }
        else {
            int tmax= Math.max(min,max-lt);
            int tmin= Math.min(min,max-lt);
            int tt= tmax/2+1;
            arr[1]=tt*tmin;
            arr[2]= (tmax-tt)*tmin;
        }
        Arrays.sort(arr);
        return arr[2]-arr[0];
    }
}
