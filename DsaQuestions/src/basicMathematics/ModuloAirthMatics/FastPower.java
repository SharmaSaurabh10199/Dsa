package basicMathematics.ModuloAirthMatics;
/*
you are given two  nos, you have to calculate a^b. in O(log n):
 */
public class FastPower {
    public static void main(String[] args) {
        System.out.println(fastPower(2,5));
    }
    public static long fastPower(int a, int b){
        if(a==0){
            return 1;
        }
        long res=1;
        while (b>0){
            if(b%2!=0){
                res=res*a;
            }
                a=a*a;
                b/=2;
        }
        return res;
    }
}
