package rough;

import java.util.Arrays;

public class rough {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        //int[] brr=arr;
        int[] brr={3,5,6,7,9};
        brr=arr;
        brr[0]=2;
        System.out.println(Arrays.toString(brr));
    }
    public static double sqrt(double c)
    {
        if (c > 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t)
            t = (c/t + t) / 2.0;
        return t;
    }
}
