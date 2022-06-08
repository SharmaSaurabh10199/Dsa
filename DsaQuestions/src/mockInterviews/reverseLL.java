package mockInterviews;

public class reverseLL {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public static Node reverse(Node node){
        Node prev=null, curr=node;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
