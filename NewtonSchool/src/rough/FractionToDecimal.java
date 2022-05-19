package rough;

public  class FractionToDecimal {
    public static void main(String[] args) {
     //  decimal(1,7);
    }
    public   void decimal(int nu, int de){
        int first= nu/de;
        boolean flag= true;
        int second= 0;
        int rem=nu%de;
        int firstAfterDecimal= rem*10/de;
        while(rem*10/de!=firstAfterDecimal){
            rem=rem*10;
            second=second*10+rem/de;
            rem=rem%de;
            if(rem==0){
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.println(first+"."+"("+second+")");
        }
        else {
            System.out.println(first+"."+second);
        }
    }
}

