package algorithms.binarySearch;
/*
the idea os to divide the array in 3 parts and eleminating the rest 2 parts.
though the time complexity of this algorithm is log3(N), but binary search is still better because
the no of if else ladder are more in ternary search and so the computational time is more.
 */
public class TernarySearch {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,8,9,10,10,11};
        int key= 10;
        System.out.println(ternarySearch(arr,key));
    }
    // the iterative approach
    public static int ternarySearch(int[] arr, int key){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int partition= (h-l)/3;
            int mid1= l+partition;
            int mid2= h-partition;
            if(arr[mid1]==key){
                return mid1;
            }
            else if(arr[mid2]==key){
                return mid2;
            }
            else if(arr[mid1]>key){
                h=mid1-1;
            }
            else if(arr[mid2]>key){
                l=mid1+1;
                h=mid2-1;
            }
            else{
                l=mid2+1;
            }
        }
        return -1;
    }
    // the recursive approach
}
