package dataStructures.arrays;
/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint

of A[i] < A[j] and i < j.


Example 1:

Input:
N = 2
A[] = {1, 10}
Output:
1
Explanation:
A[0]<A[1] so (j-i) is 1-0 = 1.
 */
public class MaximumIndexDiff {
    static int maxDiff(int[] A, int N){
        int max=-1;
        int i=0;
        int j=N-1;
        while(i<N-1)
        {
            if(i==j)
            {
                i++;
                j=N-1;
            }
            if(A[i]<=A[j])
            {
                int length=j-i;
                if(length>max)
                {
                    max=length;
                }
                i++;
                j=N-1;
            }
            else
            {
                j--;
            }
        }
        return max;
    }
}
