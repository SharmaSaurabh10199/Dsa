package mockInterviews;

public class Intersection {
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    static Node head;
    public static Node findIntersection(Node head1, Node head2){
        int size1= getSize(head1);
        int size2= getSize(head2);
        int toStart= Math.abs(size1-size2);
        while (toStart>0){
            if(size1>size2){
                head1=head1.next;
            }
            else {
                head2=head2.next;
            }
            toStart--;
        }
        while (head1!=head2){
            head1=head2.next;
            head2=head2.next;
        }
        return head1;
    }

    public static int getSize(Node node){
        Node temp= node;
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

}
