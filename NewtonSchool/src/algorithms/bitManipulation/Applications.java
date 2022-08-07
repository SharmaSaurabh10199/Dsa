package algorithms.bitManipulation;

public class Applications {

    // check if given number is even or odd
    static void isEven(int num){
        if((num&1)==0){
            System.out.println("even no");
        }
        else {
            System.out.println("odd no");
        }
    }

    // check if ith bit is set or not
    static void checkSetBit(int num, int i){
        if(((num>>i)&1)==1){
            System.out.println("set bit");
        }
        else {
            System.out.println("unset bit");
        }
    }


    public static void main(String[] args) {
        // Set the ith bit
        int num=10;
        int i=3;
//        int ans= (1<<i)|num;

        //Unset the ith bit
        int mask= ~(1<<i);
        int ans= num&mask;

        // toggle ith bit

        int mask2= 1<<i;
        int ans2= num^mask;


    }



    //toggle the ith bit
}
