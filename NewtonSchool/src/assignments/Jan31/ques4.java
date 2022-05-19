package assignments.Jan31;

public class ques4 {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int a = s.nextInt();
//        int b = s.nextInt();
//        int c = s.nextInt();
//        int d = s.nextInt();
        System.out.println(deadlyExponentiation(12,12,12,12));
    }
    public static long deadlyExponentiation(int a, int b, int c, int d){
        long pow1= (long) Math.pow(c,d);
        long pow2= (long) Math.pow(b,pow1);
        int x= (int) (pow2%1000000006);
        long ans= (long) ((Math.pow(a,x))%1000000007)
                ;
        return ans;
    }
}
