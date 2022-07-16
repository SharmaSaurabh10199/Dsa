package algorithms.slidingWindow.variableWindow;
// this approach should not be used when the array contains negative elements, then we should proceed by map.
public class LongestSubArrWithSumk {
    static int longestSubArray(int[] arr, int k){
        int i=0,j=0,sum=0,max=-1;
        while (j<arr.length){
            if(sum<k){
                sum+=arr[j];
                j++;
            }
            else if(sum==k){
                max=Math.max(max,j-i+1);
                j++;
            }
            else {
                while (sum>k){
                    sum-=arr[i];
                    i++;
                }
                // here we need to check if this while loop stopped at sum=k, we need to store those results before in
                // increasing the results.
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,4,3,3,5,5};
        System.out.println(longestSubArray(arr,15));
    }
}
