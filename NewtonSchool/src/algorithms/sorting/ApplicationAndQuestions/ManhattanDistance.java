package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;

/*
Given N points on 2D plane, you have to setup a camp at a point such that sum of Manhattan distance all the points from
that point is minimum. If there are many such points you have to find the point with minimum X coordinate and if there
are many points with same X coordinate, you have to minimize Y coordinate.
Manhattan distance between points (x1, y1) and (x2, y2) = |x1 - x2| + |y1 - y2|.
3
3 3
1 1
3 2

Sample Output
3 2

Explanation:
Sum of distances = 1 + 3 + 0 = 4
This is the minimum distance possible.
 */
/*
solution:
        Imagine you want to find the points that are with minimum Manhatan distance to the set
        (0, 6), (1, 3), (3, 5), (3, 3), (4, 7), (2, 4)

        You form the two simpler tasks:

        For x:

        0 1 2 3 3 4
        ^-^
        And here the solution is the segment [2, 3] (note that here we have duplicated point 3
        , which I represented in probably not the most intuitive way).

        For y:

        3 3 4 5 6 7*/
public class ManhattanDistance {
    public static void main(String[] args) {
//        int[] x={1,2,2,2,2,2,3,3,4};
//        int[] y={1,2,3,4,5,6,7,8,9};
//        minManhattanDistance(x,y);
       double[] check= {0,1,2,3,3,4};
       valodate(check);
//        Scanner s= new Scanner(System.in);
//        int n= s.nextInt();
//        long[] x= new long[n];
//        long[] y= new long[n];
//        for (int i = 0; i < n; i++) {
//            x[i]=s.nextLong();
//            y[i]=s.nextLong();
//        }
//        minManhattanDistance(x,y,n);
    }
    public static void minManhattanDistance(long[] x, long[] y, int n){
        Arrays.sort(x);
        Arrays.sort(y);
        int resx=0, resy=0;
      if(n%2==0){
          resx= (int) x[n/2-1];
          resy= (int) y[n/2-1];
      }
      else {
          resx=(int)x[n/2];
          resy= (int) y[n/2];
      }
        System.out.println(resx+" "+resy);
    }
    public static void valodate(double[] arr){
        double x=4;
        double sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=Math.abs(arr[i]-x);
        }
        System.out.println(sum);

    }
}
