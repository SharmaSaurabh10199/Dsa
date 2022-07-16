package mockInterviews;

public class queueUsingLl {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int size;
    public void add(int val){
        Node newNode= new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else {
            tail.next=newNode;
            tail=tail.next;
        }
        this.size++;
    }
    public int poll(int val){
        if(head==null){
            System.out.println("empty queue");
            return Integer.MIN_VALUE;
        }
        int valToReturn=this.head.val;
        this.head=this.head.next;
        this.size--;
        return valToReturn;
    }
    public int peek(int val){
        if(head==null){
            System.out.println("empty queue");
            return Integer.MIN_VALUE;
        }
        return head.val;
    }
}
