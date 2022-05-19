package dataStructures.arrays;
/*
Given an positive integer N and a list of N integers A[]. Each element in the array denotes the maximum length of
 jump you can cover. Find out if you can make it to the last index if you start at the first index of the list.


Example 1:

Input:
N = 6
A[] = {1, 2, 0, 3, 0, 0}
Output:
1
Explanation:
Jump 1 step from first index to
second index. Then jump 2 steps to reach
4th index, and now jump 2 steps to reach
the end.
 */
public class
JumpGame {
    static boolean jumpGame(int[] A,int N){
        if(A[0]==0)
            return false;

        int reach=A[0];
        for(int i=1;i<N;i++){
            if(reach--!=0) {
                reach = Math.max(reach, A[i]);
            }
            if(i!=N-1 && reach==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr= {2,3,1,0,3,0,0,1};
        System.out.println(jumpGame(arr,arr.length));
    }
}
