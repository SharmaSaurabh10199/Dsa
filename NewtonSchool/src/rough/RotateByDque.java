package rough;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RotateByDque {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotate(arr,1);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] arr, int k){
        Deque<Integer> dq= new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            dq.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            dq.addFirst(dq.removeLast());
        }
       // System.out.println(dq);
        for (Integer item: dq) {
            System.out.println(item);
        }
    }
}
