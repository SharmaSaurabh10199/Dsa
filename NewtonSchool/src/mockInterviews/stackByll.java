package mockInterviews;

public class stackByll {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node top;
    int size;
    public stackByll(){
        this.size=0;
    }
    public void push(int val){
        Node newNode = new Node(val);
        if(top==null){
            top=newNode;
        }
        else {
            Node oldtop= top;
            newNode.next=oldtop;
            top=newNode;
        }
        this.size++;
    }
    public int pop(){
        if(top==null){
            System.out.println("stack underflow");
            return Integer.MIN_VALUE;
        }
        int valToReturn= this.top.val;
        this.top=this.top.next;
        this.size--;
        return valToReturn;
    }
    public int peek(){
        if(top==null){
            System.out.println("stack underflow");
            return Integer.MIN_VALUE;
        }
        return top.val;
    }
}
