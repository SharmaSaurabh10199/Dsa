package contests;

// import com.sun.deploy.util.SyncAccess;

import java.util.Arrays;
import java.util.Scanner;

public class contests {
    static boolean isPossible(long[] arr, long x) {
        Arrays.sort(arr);
        if (arr[0] + arr[1] <= x) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        if (isPossible(arr, x)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
