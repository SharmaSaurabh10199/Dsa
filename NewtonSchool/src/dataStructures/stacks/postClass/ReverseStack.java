package dataStructures.stacks.postClass;

import java.util.Stack;

public class
ReverseStack {
    static Stack<Integer> St = new Stack();
    static void Reverse_Stack(){
//Enter your code here
        if(St.size()>0){
            int a= St.pop();
            Reverse_Stack();
            insertAtBottom(a);
        }
    }
    static void insertAtBottom(int x){
        if(St.isEmpty()){
            St.push(x);
        }
        else {
            int a=St.pop();
            insertAtBottom(x);
            St.push(a);
        }
    }
}
