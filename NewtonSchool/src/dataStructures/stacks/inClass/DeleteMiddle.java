package dataStructures.stacks.inClass;

import java.util.Stack;

public class DeleteMiddle {
    // with using additionl data structure
    public void deleteMid(Stack<Integer> s, int sizeOfStack){
        // code here
        Stack<Integer> temp= new Stack<>();
            int i=0;
            while (i<=sizeOfStack/2){
                temp.push(s.pop());
                i++;
            }
            temp.pop();
            while (!temp.isEmpty()){
                s.push(temp.pop());
            }
    }
    // without using additional datastructre:
    public void deleteMid(Stack<Integer> s, int sizeOfStack, int curr){
        // code here
        if(s.isEmpty() || curr==sizeOfStack){
            return;
        }
        int x= s.pop();
        deleteMid(s,sizeOfStack,curr+1);
        if(curr!=sizeOfStack/2){
            s.push(x);
        }

    }
}
