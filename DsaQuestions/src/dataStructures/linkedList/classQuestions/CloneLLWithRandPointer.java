package dataStructures.linkedList.classQuestions;
/*
A linked list of length n is given such that each node contains an additional random pointer, which could point
to any node in the list, or null.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two
nodes x and y in the copied list, x.random --> y.
 */
public class CloneLLWithRandPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node old=head;
        while (old!=null){
            Node newNode= new  Node(old.val);
            newNode.next=old.next;
            old.next=newNode;
            old=old.next.next;
        }
        old=head;
        while (old!=null){
            if(old.random!=null){old.next.random=old.random.next;}

            old=old.next.next;
        }
        old=head;
        Node newnode= old.next;
        Node res=newnode;
        while (old!=null){
            old.next=old.next.next;

            if(newnode.next!=null) {
                newnode.next = newnode.next.next;
            }
            old=old.next;
            newnode=newnode.next;
        }
        return res;
    }
}
