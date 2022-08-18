package mockInterviews;

// 234  -> 2*3*4
public class numProduct {
    static int numProducts(int num) {
        if (num < 10) {
            return num;
        }
        return (num % 10) * numProducts(num / 10);
    }

    public static void main(String[] args) {

        // int n=-22;
        // if(n<0){
        // System.out.println(-numProduct(Math.abs(n)));
        // }
        // else {
        // System.out.println(numProduct(n));
        // }
        System.out.println(factSum(4));

    }

    // sum of fibonacchi
    static int fibSum(int n) {
        int[] dp = new int[n + 1];
        int[] fibSum = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        fibSum[0] = 1;
        fibSum[1] = 2;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            fibSum[i] = fibSum[i - 1] + dp[i];
        }
        return fibSum[n];
    }

    // factorialSum
    static int factSum(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i * dp[i - 1];
            sum += dp[i];
        }
        return sum;
    }

}
