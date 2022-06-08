package algorithms.sorting.ApplicationAndQuestions;

import java.util.Arrays;

/*
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms
required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never
be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given
 instance of time, same platform can not be used for both departure of a train and arrival of another train. In such
 cases, we need different platforms.


Example 1:

Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}

dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.
// */
//----------
//the logic is that if a train arrives before the earlier train departs, the platform gets increased;
public class MinimumPlatforms {
    public static void main(String[] args) {

    }
    public static int minPlatforms(int[] arr, int[] dep,int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int c=0;
        int i=0,j=0,max=1;
        while (i<n && j<n){
            if(arr[i]<=dep[j]){
                c++;
                i++;
            }
            else {
                c--;
                j++;
            }
            max=Math.max(max,c);
        }
        return max;
    }
}