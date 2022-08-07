package contests;

import java.util.Scanner;

public class kedane {
    int max_so_far = Integer.MIN_VALUE;
     int maxSubArraySum(int a[], int size)
    {

            int    max_ending_here = 0,start = 0,
                end = 0, s = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        return (end - start + 1);
    }

    public static void main(String[] args) {
        /*
        3 1
-1 5 -2
         */
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int x= s.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        kedane k= new kedane();
        int sum=0;

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            arr[i]=-arr[i];
        }
        int len= k.maxSubArraySum(arr,arr.length);
        int min= -(k.max_so_far);
        if(len*x>min){
            sum=sum-min+len*x;
        }
        System.out.println(sum);


    }

}
