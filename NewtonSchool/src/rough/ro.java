package rough;

import javax.xml.soap.Node;
import java.util.Stack;

public class ro {
    static boolean flag=true;
    public static String nextGreaterPalin(String str, int n){
        if(n<4){
            return "-1";
        }
        int i=n/2;
        String toAlter=str.substring(0,i);
        //StringBuilder sb= new StringBuilder(str.substring(0,i));
        char[] ch= toAlter.toCharArray();
        nextGreater(ch,ch.length);
        if(flag==false){
            return "-1";
        }
        StringBuilder sb= new StringBuilder(String.valueOf(ch));
        StringBuilder sb2= new StringBuilder(sb);
        sb2.reverse();
        if(n%2==0){
            sb.append(sb2);
        }
        else {
            sb.append(str.charAt(i));
            sb.append(sb2);
        }
        return sb.toString();
    }
    public static void nextGreater(char[] arr, int n) {
        int smallest = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                smallest = i;
                break;
            }
        }
        if (smallest == -1) {
            flag=false;
            return;
        }
        int secondSmall = smallest + 1;
        for (int i = smallest + 1; i < n; i++) {
            if (arr[i] > arr[smallest] && arr[smallest + 1] > arr[i]) {
                secondSmall = i;
            }
        }
        swap(arr, secondSmall, smallest);
        reverse(arr, smallest + 1, n - 1);

    }

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str="5252525";
        System.out.println(nextGreaterPalin(str,str.length()));
    }

}
