package dataStructures.linkedList.homeWork;
/*
Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

Example 1:

Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output: 8 9 2 4 7
Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
 */
public class RotateaLL {
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public Node rotate(Node head, int k) {
        // add code here
        Node curr=head;
        int i=1;
        while(i<k){
            curr=curr.next;
            i++;
        }
        if(curr.next==null){
            return head;
        }
        Node newHead=curr.next;
        curr.next=null;
        Node curr2=newHead;
        while(curr2.next!=null){
            curr2=curr2.next;
        }
        curr2.next=head;
        return newHead;
    }
}
