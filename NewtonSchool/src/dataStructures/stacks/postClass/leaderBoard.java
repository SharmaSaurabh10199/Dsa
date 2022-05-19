package dataStructures.stacks.postClass;

import java.util.Scanner;
import java.util.Stack;

/*
Peter Parker is taking part in a competition where Mr Tony Stark has come to see Peter lift the cup.
 But Tony can't tell what position Peter is on since the school authorities didn't display a leaderboard.
  Help Tony Identify which rank is Peter on by seeing his victory status in different rounds.
  Points are awarded on solving every question based on the difficulty level of the question which are
  divided into subcategories. The player with the highest score is ranked number 1 on the leaderboard.
  Players who have equal scores receive the same ranking number, and the next player(s) receive the
   immediately following ranking number.
Input
The first line contains an integer n, the number of participants on the leaderboard.
The next line contains n space- separated integers containing the leaderboard points in decreasing
 order in the competition. The next line contains an integer m, denoting the number of times Peter
 is attempting the question. The last line contains m space- separated integers containing Peter's
 score in each attempt in the competition.


 7
100 100 50 40 40 20 10
4
5 25 50 120
op
6 4 2 1
 */
public class leaderBoard {
    public static void tellRank(int[] leaderBoard, int n, int[] peter, int m ){
        Stack<Integer> st= new Stack<>();
        for (int i = 0; i < n-1; i++) {
            if(leaderBoard[i]!=leaderBoard[i+1]){
                st.push(leaderBoard[i]);
            }
        }
        st.push(leaderBoard[n-1]);
        for (int i = 0; i < m; i++) {
            if(peter[i]>=st.peek()){
                while (!st.isEmpty()&& peter[i]>=st.peek()){
                    st.pop();
                }
            }
            st.push(peter[i]);
            System.out.println(st.size());
        }
    }

    public static void main(String[] args) {
//        int[] l={100,100,50,40,40,20,10};
//        int[] p={5,25,50,120};
//        tellRank(l,l.length,p,p.length);
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int[] leaderboard= new int[n];
        for (int i = 0; i < n; i++) {
            leaderboard[i]=s.nextInt();
        }
        int m= s.nextInt();
        int[] peter = new int[m];
        for (int i = 0; i < m; i++) {
            peter[i]=s.nextInt();
        }
        tellRank(leaderboard,n,peter,m);
    }

}
