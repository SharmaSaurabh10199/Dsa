package basicMathematics.PrimeNos;

public class primeNoTillN {
    public static void main(String[] args) {
   printPrimes(70);
   sieveOfErastomers(70);
    }
    // brut force method
    public static void printPrimes(int n){
        for (int i=2; i<=n; i++){
            if(checkPrimeOptimised(i)){
                System.out.print(i+" ");
            }
        }

    }
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
    // a bit better solution could be
    public static boolean checkPrimeOptimised(int n){
        if(n<=1){
            return false;
        }
        if(n<=3){
            return true;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5; i*i<=n; i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    // sieve of erastomers, most optimised solution
    public static void sieveOfErastomers(int n){
        int[] arr= new int[n+1];
        for(int i=2; i*1<=n;i++){
            if(arr[i]==0){
                for(int j=i*i; j<=n;j+=i){
                    arr[j]=1;
                }
            }
        }
        for (int i=2; i<=n;i++){
            if(arr[i]==0){
                System.out.print(i+" ");
            }
        }
    }
}
