package mockInterviews;

public class RemoveLoop {
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    static Node head;

    public static void main(String[] args) {
        RemoveLoop r= new RemoveLoop();
        r.head=new Node(1);
        r.head.next= new Node(2);
        r.head.next.next=new Node(3);
        r.head.next.next.next=r.head.next;
    }
    public void print(Node node){
        Node temp=node;
        while (temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
    public void removeLoop(Node node){
        Node slow=node;
        Node fast=node;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=head;
        if(fast==head){
            while (slow.next!=fast){
                slow=slow.next;
            }
            slow.next=null;
        }
        else{
            while (slow.next!=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            fast.next=null;
        }
    }
}
