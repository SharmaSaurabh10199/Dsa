package contests;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodBuildings {
    static void goodBuildings(int[] arr){
        int greaterTillNow=0;
        ArrayList<Integer> ls= new ArrayList<>();
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i]>greaterTillNow){
                greaterTillNow=arr[i];
                ls.add(arr[i]);
            }
        }
        for (int i = ls.size()-1; i >=0 ; i--) {
            System.out.print(ls.get(i)+" ");
        }
    }

    public static void main(String[] args) {
//        Scanner s= new Scanner(System.in);
//        int n= s.nextInt();
//        int[] arr= new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]=s.nextInt();
//        }
        int[] arr= {3,7,6,1,2,1};
        goodBuildings(arr);

    }
}
