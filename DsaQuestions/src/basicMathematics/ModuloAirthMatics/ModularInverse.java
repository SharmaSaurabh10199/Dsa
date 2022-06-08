package basicMathematics.ModuloAirthMatics;
/*
Method 3 (Works when m is prime)
If we know m is prime, then we can also use Fermats’s little theorem to find the inverse.

am-1 ≅ 1 (mod m)
If we multiply both sides with a-1, we get

a-1 ≅ a m-2 (mod m)

note: this is just valid for prime nos only:
 */

public class ModularInverse {
    public static void main(String[] args) {
        ModularInverse inv= new ModularInverse();
       // System.out.println(inv.modularInverse(10,17));

    }
    public  int modularInverse(int a, int m){
        if(gcd(a,m)!=1){
            return -1;
        }
     //   int res= powerOfBigNos(a,m-2,m);
     //    return res;
        return 0;
    }
    public static int gcd(int x, int y){
        int a=Math.max(x,y);
        int b=Math.min(x,y);
        while (a%b!=0){
            int r= a%b;
            a=b;
            b=r;
        }
        return b;
    }
//    public  int  powerOfBigNos(int a, int b,int p){
//        a=a%p;
//        if(a==0){
//            return 0;
//        }
//        int res=1;
//        while (b>0){
//            if((b & 1) != 0){
//                res=((res%p)*(a%p))%p;
//            }
//            a=((a%p)*(a%p))%p;
//            b=b/2;
//        }
//        return res;
//    }
}
