package basicMathematics;

public class playingwithjavaLIs {

    public static void main(String[] args) {

         double b=  Math.random();
        System.out.println(b);
        int[] arr= {1,2,3,4};
        //System.out.println(PI);
        String s="sonu";
        //int x=3;
//        int x= Integer.parseInt("");
//        System.out.println(x);
//        int y= Math.abs(-2147483);
//        System.out.println(y);
//        double d= Double.POSITIVE_INFINITY;
//        double d2=1/0;
//        System.out.println(d2);
    //-------------------------------------------
    // modulo operator for nrgative nos:
    /*
         x = 5 % (-3);
 y = (-5) % (3);
 z = (-5) % (-3);

printf("%d ,%d ,%d", x, y, z);
It gave me output as (2, -2 , -2) in gcc. I was expecting a positive result
  solution:
   99 requires that when a/b is representable:

(a/b) * b + a%b shall equal a

This makes sense, logically. Right?

Let's see what this leads to:

Example A. 5/(-3) is -1

=> (-1) * (-3) + 5%(-3) = 5

This can only happen if 5%(-3) is 2.

Example B. (-5)/3 is -1

=> (-1) * 3 + (-5)%3 = -5

This can only happen if (-5)%3 is -2
-----------------------------------------------------
     */
        System.out.println( 1 + 2 + "3");
        System.out.println((1 + 2.236)/2);

    }
    public static double binomial(int N, int k, double p)
    {
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p)*binomial(N-1, k,p) + p*binomial(N-1, k-1,p);
    }
}
