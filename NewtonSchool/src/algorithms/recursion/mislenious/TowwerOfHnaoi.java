package algorithms.recursion.mislenious;

public class TowwerOfHnaoi {
    static int count=0;
    public static void main(String[] args) {
        char a = 'a',b='b',c='c';
        toh(3,a,b,c);
        System.out.println(count);
    }
    public static void toh(int n, char a, char b, char c){

        if(n==0){
            count++;
            return;

        }
        toh(n-1, a, c, b);
        System.out.println(n+" from "+ a+" to "+ c);
        toh(n-1,b,a,c);
    }
}
