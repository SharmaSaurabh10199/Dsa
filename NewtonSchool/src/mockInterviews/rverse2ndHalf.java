package mockInterviews;

public class rverse2ndHalf {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public static Node  reverseSecondHalf(Node node){
        Node middle=findMiddle(node);
        Node nextToMiddle=reverse(middle.next);
        middle.next=nextToMiddle;
        return node;
    }
    public static Node findMiddle(Node node){
        Node slow= node;
        Node fast= node;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node node){
        Node prev=null,curr=node;
        while (curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
