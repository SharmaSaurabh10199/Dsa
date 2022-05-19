package algorithms.recursion.mislenious;

public class KthSymbolInGrammer {
    public static void main(String[] args) {
        System.out.println(genrateNum(4,3));
    }
    public static int genrateNum(int n, int k){
        if(k>Math.pow(2,n-1) || k<1){
            System.out.println("inavlid input");
            return Integer.MIN_VALUE;
        }
        if(n==1 && k==1){
            return 0;
        }
        int mid= (int) (Math.pow(2,n-1)/2);
        if(k<=mid){
            return genrateNum(n-1,k);
        }
        else{
            return 1-genrateNum(n-1,k-mid);
        }
    }
}
