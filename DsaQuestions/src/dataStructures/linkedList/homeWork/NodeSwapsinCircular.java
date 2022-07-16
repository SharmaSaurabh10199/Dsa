package dataStructures.linkedList.homeWork;
/*
Given Circular linked list exchange the first and the last node. The task should be done with only one extra node,
you can not declare more than one extra node, and also you are not allowed to declare any other temporary variable.
Note: Extra node means the need of a node to traverse a list

Input : 5 4 3 2 1
Output : 1 4 3 2 5

Input  : 6 1 2 3 4 5 6 7 8 9
Output : 9 1 2 3 4 5 6 7 8 6
 */
public class NodeSwapsinCircular {
    class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }
    public static Node exchangeNodes(Node head) {
//Enter your code here
        Node curr=head;
        Node prev=null;
        while (curr.next!=head){
            prev=curr;
            curr=curr.next;
        }
        prev.next=head;
        curr.next=head.next;
        head.next=curr;
        return curr;
    }
}
