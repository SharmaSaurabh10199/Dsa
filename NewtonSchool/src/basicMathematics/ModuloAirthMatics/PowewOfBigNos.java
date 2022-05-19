package basicMathematics.ModuloAirthMatics;
/*
 if a,b are pretty big nos, you have to calculate a^b%p;
 here p=10^9+7;
 */
public class PowewOfBigNos {
    public static void main(String[] args) {
       // System.out.println(powerOfBigNos(2,100,1000000007));
        System.out.println(-2%7);
    }
    public  long  powerOfBigNos(int a, int b,int p){
        a=a%p;
        if(a==0){
            return 0;
        }
        long res=1;
        while (b>0){
            if((b & 1) != 0){
                res=((res%p)*(a%p))%p;
            }
            a=((a%p)*(a%p))%p;
            b=b/2;
        }
       return res;
    }
}
