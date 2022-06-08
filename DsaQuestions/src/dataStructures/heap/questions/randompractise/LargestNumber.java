package dataStructures.heap.questions.randompractise;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).

Return the largest possible value of num after any number of swaps.



Example 1:

Input: num = 1234
Output: 3412
Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
Swap the digit 2 with the digit 4, this results in the number 3412.
Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
Also note that we may not swap the digit 4 with the digit 1 since they are of different parities
 */
public class LargestNumber {
    public int largestInteger(int num) {
        String str= Integer.toString(num);
        StringBuilder res= new StringBuilder();
        PriorityQueue<Character> odd= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Character> even= new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < str.length(); i++) {
            int n= str.charAt(i)-'0';
            if(n%2!=0){
                odd.add(str.charAt(i));
            }
            else {
                even.add(str.charAt(i));
            }
        }
        for (int i = 0; i < str.length(); i++) {
            int n= str.charAt(i)-'0';
            if(n%2==0){
                res.append(even.poll());
            }
            else {
                res.append(odd.poll());
            }
        }


        return Integer.parseInt(res.toString());

    }

    public static void main(String[] args) {
        System.out.println('9'-'0');
    }
}
