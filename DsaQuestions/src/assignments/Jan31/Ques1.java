package assignments.Jan31;

public class Ques1 {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int a = s.nextInt();
//        int b = s.nextInt();
//        System.out.println(countCandyWays(n,a,b));
        System.out.println(nCr(100000,278));
    }
    public static long countCandyWays(int n, int a, int b){
        int sum=0;
        int res=0;
   /*     if(n%2!=0){
            for (long i = 0; i <=n/2 ; i++) {
              sum+=nCr(n,i);
            }
            sum=sum*2;
             res= sum-nCr(n,0)-nCr(n,a)-nCr(n,b);
            return res%1000000007;
        }
        for (int i = 0; i < n/2; i++) {
            sum+=nCr(n,i);
        }
        long mid= nCr(n,n/2);
        res= sum*2+ mid-nCr(n,0)-nCr(n,a)-nCr(n,b);
        return res%1000000007; /*
        /*------------------------------------------------------*/
        // the sum of the nth row of the pascal's trianglle is 2^n;
        if(n<=30){
            sum= (int) Math.pow(2,n);
            res= (int) (sum-nCr(n,0)-nCr(n,a)-nCr(n,b));
            return res;
        }
        return 1000000007;
    }
    public static long nCr(long n, long r){
        long p=1, k=1;
        if(n-r<r){
            r=n-r;
        }
        if(r==0){
            return 1;
        }
        while(r>0){
            p=p*n;
            k=k*n;
            long m= gcd(p,r);
            p=p/m;
            k=k/m;
            n--;
            r--;
        }
        return p;
    }
    public static long gcd(long x, long y){
        long a=Math.max(x,y);
        long b=Math.min(x,y);
        while (a%b!=0){
            long r= a%b;
            a=b;
            b=r;
        }
        return b;
    }
}
