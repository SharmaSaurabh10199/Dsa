package basicMathematics.PrimeNos;
// count the no of factors in optimised way
public class FactorsOfN {
    public static void main(String[] args) {
        findFactors(763778835);
    }
    public static void findFactors(int n){

        int count =2;
        for(int i=2; i*i<=n;i++){
            if(n%i==0){
                count++;
                if(n%i!=i){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
