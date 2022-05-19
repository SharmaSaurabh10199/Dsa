package dataStructures.linkedList.homeWork;
/*
Given a linked list of size N. The task is to reverse every k
nodes (where k is an input to the function) in the linked list.
 If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered
 as a group and must be reversed (See Example 2 for clarification).

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4
 */
public class
reverseLLinGroups {
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    public static Node reverse(Node head, int k){
        Node curr=head,prev=null,next=null;
        int count=0;
        while (curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            head.next=reverse(next,k);
        }
        return prev;
    }
}
