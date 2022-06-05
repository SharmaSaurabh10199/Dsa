package algorithms.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class possibleWordsFromPhone {
    static String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static void combinations(int[] arr, int index, String run,ArrayList<String> li){
        if(index==arr.length){
            li.add(run);
            return;
        }
        String curr= keys[arr[index]];
        for(int i=0; i<curr.length(); i++){
            combinations(arr,index+1,run+curr.charAt(i),li);
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int tc= sc.nextInt();
        while (tc>0){
            int n= sc.nextInt();
            int[] arr= new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]= sc.nextInt();
            }
            ArrayList<String> res= new ArrayList<>();
            combinations(arr,0,"",res);
            Collections.sort(res);
            for(String str: res){
                System.out.print(str+" ");
            }
            System.out.println();
            tc--;
        }
    }
}
