package dataStructures.linkedList.classQuestions;

public class MidOfLL {
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
    void printList(RverseOfll.Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        MidOfLL list = new MidOfLL();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node (20);
         middleOfLl(head);
    }
    public static void middleOfLl(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){ // the codition for the left middle part will be fast.next.next!=null && fast.next!=null;
            slow=slow.next;
                fast=fast.next.next;

        }
        System.out.println(slow.data);
    }
}
