package basicMathematics.PrimeNos;

public class CheckPrime {

    public static void main(String[] args) {
        System.out.println(checkPrimeBySqrt(29));
    }
// naive approach for prime no
    public static boolean checkPrimeNaive(int n){
        if(n<=1){
            return false;
        }
            for(int i=2; i<=n/2; i++){
                if(n%i==0){
                    return false;
                }
            }
        return true;
    }
    // optimized approach for prime no
    public static boolean checkPrimeBySqrt(long n){
        int sqrt= (int)Math.sqrt(n);
        if(n<=1){
            return false;
        }
        for(int i=2; i<=sqrt; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
