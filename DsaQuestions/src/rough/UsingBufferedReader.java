package rough;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsingBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
//       int n= Integer.parseInt(inp.readLine()); // for taking a number as an input
//      /*  int U= Integer.parseInt(inp.readLine());
//        char c= (char) inp.read();   // for taking character as the input;
//        String str = inp.readLine(); // for taking a string as an input
//        System.out.println(T+U);
//        System.out.println(T);
//        System.out.println(str); */
//        int a[] = new int[n];
//        String line = inp.readLine(); // to read multiple integers line
//        String[] strs = line.trim().split("\\s+");
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(strs[i]);
//        }


//        int t = Integer.parseInt(inp.readLine().trim()); //Inputting the testcases
//        while(t-->0){
//            String line = inp.readLine();
//            String[] str = line.trim().split("\\s+");
//            int n = Integer.parseInt(str[0]);
//            int k = Integer.parseInt(str[1]);
//            int arr[] = new int[n];
//            String inputLine[] = inp.readLine().trim().split("\\s+");
//            for(int i=0; i<n; i++){
//                arr[i] = Integer.parseInt(inputLine[i]);
//            }
//            System.out.println(longestSubArrayByHashing(arr,k,n));
//        }
        int t = Integer.parseInt(inp.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(inp.readLine());
            int a[] = new int[n];
            String line = inp.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(1);
        }
    }
}
