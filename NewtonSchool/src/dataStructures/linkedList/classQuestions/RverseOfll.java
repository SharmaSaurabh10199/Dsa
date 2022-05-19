package dataStructures.linkedList.classQuestions;

public class RverseOfll {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        RverseOfll list= new RverseOfll();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
       // reverse(head);
      //  list.printList(head);
        list.printList(reverseBypointer(head));

    }
    // the data reversai,time complexity is O(n2);
     public static void reverse(Node head){
        Node iterator= head;
        int size=0;
        while (iterator!=null){
            iterator=iterator.next;
            size++;
        }
        int i=0;
        while (i<size/2){
            Node left=getNodeAtIdx(i);
            Node right=getNodeAtIdx(size-1-i);
            int  temp=left.data;
            left.data=right.data;
            right.data=temp;
            i++;
        }
     }
     public static Node getNodeAtIdx(int idx){
      Node iterator=head;
      while (idx>0){
          iterator=iterator.next;
          idx--;
      }
        return iterator;
     }
     // pointer reversal of the node;
    public static Node reverseBypointer(Node head){
        Node prev=null;
        Node curr=head;

        while (curr!=null){
            Node nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        head=prev;
        return prev;
    }

}
