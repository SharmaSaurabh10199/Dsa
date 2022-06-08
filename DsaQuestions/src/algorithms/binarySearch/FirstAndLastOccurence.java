package algorithms.binarySearch;
/*
you are given an array, you have to print the begin index and the end index of a given key, print -1 if the
key is not present;
 */
public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,4};
        findOccurances(arr,9);
    }
    public static void findOccurances(int[] arr, int key){
        int idx= binarySearch(arr,key);
        if(idx!=-1){
            int i=idx,j=idx;
            while(j>0 && arr[j]==arr[j-1]){
                j--;
            }
            while (i<arr.length-1 && arr[i]==arr[i+1]){
                i++;
            }
            System.out.println("first index is "+j);
            System.out.println("last index is "+i);
        }
        else {
            System.out.println("element not present");
        }
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
