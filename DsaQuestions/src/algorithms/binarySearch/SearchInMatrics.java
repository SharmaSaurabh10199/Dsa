package algorithms.binarySearch;
/*
given a sored matrics, you need to find the key element in it.
 */
public class
SearchInMatrics {
    public static void main(String[] args) {
        int[][] arr = {{1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}};
         searchin2dArray(arr,30);
    }
    public static void searchin2dArray(int[][] arr, int key){
        int i=0,j=arr[0].length-1;
        int n=arr.length;
        int m= arr[0].length;
        boolean flag=false;
        while ( i<n && j>=0 ){
            if(arr[i][j]==key){
                System.out.println(i+" "+j);
                flag=true;
                break;
            }
            else if(arr[i][j]<key){
                i++;
            }
            else {
                j--;
            }
        }
        if(flag==false){
            System.out.println("not present");
        }
    }
}
