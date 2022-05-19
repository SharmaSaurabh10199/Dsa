package rough;

import java.util.Scanner;

public class MissingNo {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t= s.nextInt();
        int[] arr= new int[t-1];
        int sum=0;
        for(int k=0; k<t-1; k++){
            arr[k]=s.nextInt();
            sum+=arr[k];
        }
        int actualSum= t*(t+1)/2;
        int missingNo= actualSum-sum;
        System.out.println(missingNo);
    }
}
