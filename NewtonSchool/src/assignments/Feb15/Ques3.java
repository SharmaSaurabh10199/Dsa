package assignments.Feb15;

public class Ques3 {
    public static void main(String[] args) {
        int[] arr= {2,5,6,11,15};
        System.out.println(smallerElements(arr,arr.length,2));
    }
    static int smallerElements(int arr[], int n, int key){
        //Enter your code here
        int low=0;
        int high= arr.length-1;
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(arr[mid]==key){
                return mid+1;
            }
            else if(arr[mid]<key){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high+1;
    }
}
