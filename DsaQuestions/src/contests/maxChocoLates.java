package contests;

public class maxChocoLates {
    class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }
    public static int maxChocolates(Node head) {
//Enter your code here
        Node middle= findmiddle(head);
        Node nextToMiddle= middle.next;
        middle.next=null;
        Node head2= reverse(nextToMiddle);
        int max=Integer.MIN_VALUE;
        while (head!=null && head2!=null){
            if(max<(head.val+ head2.val)){
                max= head.val+ head2.val;
            }
            head=head.next;
            head2=head2.next;
        }
        return max;

    }
    public static Node findmiddle(Node node){
        Node slow=node;
        Node fast=node;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node node){
        Node prev=null;
        Node curr=node;
        while (curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
