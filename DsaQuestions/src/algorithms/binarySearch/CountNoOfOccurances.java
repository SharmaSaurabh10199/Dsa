package algorithms.binarySearch;
/*
You are given a sorted array, you have to count the no of times a element occurs in the array, if it is not
present, return -1;
 */
public class CountNoOfOccurances {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,4};
        System.out.println(findCount(arr,0));
    }
    public static int findCount(int[] arr, int key){
        int idx=binarySearch(arr,key);
        int cont=1;
        if(idx!=-1){
            int i=idx,j=idx;

            while(j>0 && arr[j]==arr[j-1]){
                cont++;
                j--;
            }
            while (i<arr.length-1 && arr[i]==arr[i+1]){
                cont++;
                i++;
            }
            return cont;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int key){
        int low=0;
        int high= arr.length-1;
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
