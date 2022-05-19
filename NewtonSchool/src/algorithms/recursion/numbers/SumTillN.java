package algorithms.recursion.numbers;

public class SumTillN {
    public static void main(String[] args) {
        System.out.println(add(10));
    }
    public static long add(int n){
        if(n==1){
            return 1;
        }
        return add(n-1)+n;
    }
}
