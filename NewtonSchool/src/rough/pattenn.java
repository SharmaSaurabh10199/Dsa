package rough;

public class pattenn {
    public static void pattern_making(int n){
        for (int i = 1; i <=n; i++) {
           int j;
            for (j = 1;  j<=i ; j++) {
                System.out.print(j+" ");
            }
            j-=2;
            while (j>0){
                System.out.print(j+" ");
                j--;
            }
            System.out.println();
        }
        for (int i = n-1; i >0 ; i--) {
            int j;
            for(j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            j-=2;
            while (j>0){
                System.out.print(j+" ");
                j--;
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        pattern_making(5);
    }
}
