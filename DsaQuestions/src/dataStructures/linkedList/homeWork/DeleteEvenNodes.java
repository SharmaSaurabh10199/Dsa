package dataStructures.linkedList.homeWork;
/*
Given a circular singly linked list containing N nodes, the task is to delete all the even nodes from the list.
Sample Input:-
Note: given that first element will always be odd:
1- >2- >3- >4- >1

Sample Output:-
1- >3- >1
 */
public class

DeleteEvenNodes {
    class Node
    {
        int data;
        Node next;
        Node(int x)
        {
            data = x;
            next = null;
        }
    };

    static Node deleteEven(Node head){
//Enter your code here
        if(head==null){
            return null;
        }
        Node curr=head.next;
        Node pev=head;
        while (curr!=head){
            if(curr.data%2==0){
                //Node temp=curr;
                curr=curr.next;
                pev.next=curr;
                //temp=null;
            }
            else{
                pev=curr;
                curr=curr.next;
            }
        }
        return head;
    }
}
