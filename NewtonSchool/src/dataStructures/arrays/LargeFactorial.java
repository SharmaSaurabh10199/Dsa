package dataStructures.arrays;

/*

You are given an array A of integers of length N. You need to calculate factorial of each number. The answer can be very large, so print it modulo 109 + 7.


Example 1:

Input:
N = 5
A[] = {0, 1, 2, 3, 4}
Output:
1 1 2 6 24
Explanation:
Factorial of 0 is 1,
factorial of 1 is 1, factorial of 2 is 2,
factorial of 3 is 6 and so on.
 */
public class LargeFactorial {
    static long[] arr;
  static void factorialSieve(long n){
       arr= new long[(int) (n+1)];
      arr[0]=1;
      for (int i = 1; i < n+1; i++) {
          arr[i]=(i*arr[i-1])%1000000007;
      }

  }
  static void facArray(long[] brr, int n){
      long max=-1;
      for (int i = 0; i < n; i++) {
          if(max<brr[i]){
              max=brr[i];
          }
      }
      factorialSieve(max);
      for (int i = 0; i < n; i++) {
          brr[i]=arr[(int) brr[i]];
      }
     // System.out.println(Arrays.toString(brr));
  }

    public static void main(String[] args) {
        long[] arr={5, 6, 3};
        facArray(arr,arr.length);
    }

}
