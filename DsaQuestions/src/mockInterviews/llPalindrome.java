package mockInterviews;

public class llPalindrome {
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }

    }
    public static boolean isPalindrome(Node node){
        if(node==null){
            return false;
        }
        Node middle=findmiddle(node);
        Node nexttoMiddle= middle.next;
        middle.next=null;
        Node head2=reverse(nexttoMiddle);

        while (node!=null && head2!=null){
            if(node.val!= head2.val){
                return false;
            }
            node=node.next;
            head2=head2.next;
        }
        return true;
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
        Node node= new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(1);
        System.out.println(isPalindrome(node));
    }
}
