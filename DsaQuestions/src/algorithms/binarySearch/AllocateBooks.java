package algorithms.binarySearch;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] arr={12,34,67,90};
        System.out.println(minPages(arr,2));
    }
    public static boolean isValid(int[] arr, int max, int k){
        int student=1;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            // if we take low as in in the array, then we need not use this condition, but if we use the low as 0,
            // then we need to use first condition.
            if(arr[i]>max){
                return false;
            }
            if(sum+arr[i]>max){
                student++;
                sum=arr[i];
                if(student>k){
                    return false;
                }
            }
            else{
                sum+=arr[i];
            }
        }
        return true;
    }
    public static int minPages(int[] arr, int m){
        if (m>arr.length){
            return -1;
        }
        int res=-1;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int lo=0,hi=sum;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isValid(arr,mid,m)){
                res=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return res;
    }
}
