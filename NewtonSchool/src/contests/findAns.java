package contests;

public class findAns {
    public static long findZero(long k){
        long lo=1;
        long hi= (long) Math.sqrt(k);
        while (lo<=hi){
            long mid= lo+(hi-lo)/2;
            long check=mid*mid+3*mid;
            if(check==k){
                return mid;
            }
            else if(check<k){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a=1000000000;
        System.out.println(findZero(a));
    }
}
