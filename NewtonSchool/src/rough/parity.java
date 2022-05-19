package rough;

import java.util.ArrayList;
import java.util.Collections;

public class parity {
    public void sortparity(int[] arr){
        int i=0,j=0;
        while (j<arr.length){
            if(arr[j]%2==0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
            j++;
        }
    }

    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        long min=Integer.MAX_VALUE;
        for(int i=0; i+m<n+1; i++){
            min=Math.min(min,a.get((int) (i+m-1))-a.get(i));
        }
        return min;
    }

}
