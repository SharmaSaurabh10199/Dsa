package mockInterviews;

import java.util.HashSet;

public class PairSum {
    public static void pairSum(int[] arr, int k){
        boolean flag=false;
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(k-arr[i])){
                System.out.println("pair exists "+arr[i]+","+(k-arr[i]));
                flag=true;
                return;
            }
            set.add(arr[i]);
        }
        if(flag==false){
            System.out.println("no pair exists");
        }
    }

    public static void main(String[] args) {
        int[] arr={4,3,1,2};
        pairSum(arr,5);
    }
}
