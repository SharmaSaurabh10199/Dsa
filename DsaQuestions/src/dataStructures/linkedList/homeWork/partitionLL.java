package dataStructures.linkedList.homeWork;
/*
Given a linked list and a value x, partition it such that all nodes less than x come first, then all nodes with value
equal to x and finally nodes with value greater than or equal to x. The original relative order of the nodes in each

of the three partitions should be preserved. The partition must work in-place.

Example 1:
Input:
1->4->3->2->5->2->3,
x = 3
Output:
1->2->2->3->3->4->5
 */
public class  partitionLL {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public static Node partition(Node node, int x) {
        // Your code here
        if(node==null){
            return null;
        }
        Node curr=node;
        Node small= new Node(-1);
        Node smallhead=small;
        Node equal= new Node(-1);
        Node equalhead= equal;
        Node large= new Node(-1);
        Node largeHead=large;
        while (curr!=null){
            if(curr.data<x){
                small.next=curr;
                small=small.next;
            }
            else if(curr.data==x){
                equal.next=curr;
                equal=equal.next;
            }
            else {
                large.next=curr;
                large=large.next;
            }
            curr=curr.next;
        }
        //large.next=null;
        if(smallhead.next!=null && equalhead.next!=null){
            small.next=equalhead.next;
            equal.next=largeHead.next;
            node=smallhead.next;
        }
        else if(smallhead.next==null && equalhead.next==null){
            node=largeHead.next;
        }
        else if(smallhead.next==null && equalhead.next!=null){
            equal.next=largeHead.next;
            node=equalhead.next;
        }
        else {
            small.next=largeHead.next;
            node=smallhead.next;
        }
        return node;
    }
    public static Node improved(Node head, int x){
          /* Let us initialize first and last nodes of
    three linked lists
        1) Linked list of values smaller than x.
        2) Linked list of values equal to x.
        3) Linked list of values greater than x.*/
        Node smallerHead = null, smallerLast = null;
        Node greaterLast = null, greaterHead = null;
        Node equalHead = null, equalLast =null;

        // Now iterate original list and connect nodes
        // of appropriate linked lists.
        while (head != null)
        {
            // If current node is equal to x, append it
            // to the list of x values
            if (head.data == x)
            {
                if (equalHead == null)
                    equalHead = equalLast = head;
                else
                {
                    equalLast.next = head;
                    equalLast = equalLast.next;
                }
            }

            // If current node is less than X, append
            // it to the list of smaller values
            else if (head.data < x)
            {
                if (smallerHead == null)
                    smallerLast = smallerHead = head;
                else
                {
                    smallerLast.next = head;
                    smallerLast = head;
                }
            }
            else // Append to the list of greater values
            {
                if (greaterHead == null)
                    greaterLast = greaterHead = head;
                else
                {
                    greaterLast.next = head;
                    greaterLast = head;
                }
            }
            head = head.next;
        }

        // Fix end of greater linked list to NULL if this
        // list has some nodes
        if (greaterLast != null)
            greaterLast.next = null;

        // Connect three lists

        // If smaller list is empty
        if (smallerHead == null)
        {
            if (equalHead == null)
                return greaterHead;
            equalLast.next = greaterHead;
            return equalHead;
        }

        // If smaller list is not empty
        // and equal list is empty
        if (equalHead == null)
        {
            smallerLast.next = greaterHead;
            return smallerHead;
        }

        // If both smaller and equal list
        // are non-empty
        smallerLast.next = equalHead;
        equalLast.next = greaterHead;
        return smallerHead;
    }
    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);
        int x = 3;
        head = partition(head, x);
        printList(head);
    }
}
