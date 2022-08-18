package mockInterviews;

import java.util.Stack;

public class queueUsingStack {
    static Stack<Integer> st1;
    static Stack<Integer> st2;

    int size;

    public queueUsingStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();

    }

    public void add(int val) {
        st1.push(val);
        this.size++;
    }

    public int poll() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int elementToreturn = st2.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        this.size--;
        return elementToreturn;
    }

    public int peek() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int elementToreturn = st2.peek();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return elementToreturn;
    }
}
