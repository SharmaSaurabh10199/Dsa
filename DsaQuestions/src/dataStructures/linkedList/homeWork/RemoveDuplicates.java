package dataStructures.linkedList.homeWork;
/*
Given a sorted doubly linked list containing n nodes. Your task is to remove duplicate nodes from the given list.

Example 1:
Input
1<->2<->2-<->3<->3<->4

Output:
1<->2<->3<->4
 */
public class

RemoveDuplicates {
    class Node {
        Node next;
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
            next = null;
            prev = null;
        }
    }

    public static Node deleteDuplicates(Node head) {
//complete this function
        if(head==null){
            return null;
        }
        Node current=head.next;
        Node previous=head;
        while (current!=null){
            if(current.val==previous.val){
//                if(current.next==null){
//                    Node temp=current;
//                    previous.next=null;
//                    temp=null;
//                }
//                else {
//                    Node temp=current;
//                    current=current.next;
//                    previous.next=current;
//                    current.prev=previous;
//                    temp=null;
//                }
                current=current.next;
                previous.next=current;
                if(current!=null){
                    current.prev=previous;
                }
            }
            else {
                current=current.next;
                previous=previous.next;
            }
        }
        return head;
    }
}
