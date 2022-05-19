package algorithms.recursion.mislenious;

import java.util.Vector;

/*
There are n people standing in a circle (numbered clockwise 1 to n)
waiting to be executed. The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction
 (clockwise). In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds
 around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains,
 who is given freedom.Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person
 is killed in circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive.



Example 1:

Input:
n = 2, k = 1
Output:
2
Explanation:
Here, n = 2 and k = 1, then safe position is
2 as the person at 1st position will be killed.
 */
public class JosephusProblem {
    static int ans=0;
    public static int findSafe(int n, int k){
        Vector<Integer> v= new Vector<>();
        for (int i = 1; i <= n; i++) {
            v.add(i);
        }
        solve(0,k-1,v);
        return ans;
    }
    public static void  solve(int index,int k,Vector<Integer> v){
        if(v.size()==1){
            ans=v.get(0);
            return;
        }
        index=(index+k)%v.size();
        v.remove(index);
        solve(index,k,v);
    }

    public static void main(String[] args) {
        System.out.println(findSafe(40,7));
    }
}
