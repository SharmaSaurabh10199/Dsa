package algorithms.bitManipulation;

public class Application2 {
    public static void main(String[] args) {
        // swap 2 numbers
        int x=9;
        int y=10;
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println(x+" "+y);

        // printing the binary of decimal number
          // inbuilt java method
        System.out.println(Integer.toBinaryString(x));
        // cutom convertion
        for (int i = 3; i >=0 ; i--) {
            System.out.print((x>>i)&1);

        }
        x=x>>3;
        System.out.println();
        System.out.println(x);

        // printing first n powers of 2
        int n=6;
        for (int i = 0; i <=n ; i++) {
            System.out.print(" "+(1<<i));
        }
        System.out.println();
        // return true if the given number is in the form 2^n, else return false
        // brian kernighan's algorithm
        if((n&n-1)==0){
            System.out.println("power of 2");
        }
        else {
            System.out.println("not a pwer of 2");
        }

        // count the no of set bits
        // application of bian kerninghn's algo
        int numer=50;
        int cnt=0;
        while (numer!=0){
            numer=numer&(numer-1);
            cnt++;
        }
        System.out.println(cnt);
    }


}
