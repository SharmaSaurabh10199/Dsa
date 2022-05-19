package Mocks;

public class findMax {
    public static void main(String[] args) {
        int[] arr={34,56,78,87,98,12,23,29};
        System.out.println(findMaxIdx(arr,arr.length));
    }
    public static int findMaxIdx(int[] arr, int n){
        if(arr[0]<arr[n-1]){
            return n-1;
        }
        int lo=0;
        int hi=n-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            int prev=(mid-1+n)%n;
            int next=(mid+1+n)%n;
            if(arr[mid]>arr[prev] && arr[mid]>arr[next]){
                return mid;
            }
            else if(arr[mid]>arr[prev]){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return -1;
    }
}
