package dataStructures.linkedList.homeWork;
/*
A number (n) is represented in Linked List such that each digit corresponds to a node in linked list. Add 1 to it.

Note:- Linked list representation of a number is from left to right i.e if the number is 123 than in linked list it is represented as 3->2->1
 */
public class Add1Toll {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static Node add1(Node head){
        Node curr=head;
        int sum=0, carry=1;
        while (curr.next!=null){
            sum=curr.data+carry;
            curr.data=sum%10;
            carry=sum/10;
            curr=curr.next;
        }
        sum= curr.data+carry;
        curr.data=sum;
        // carry=sum/10;
        // if(carry>0){
        //     Node newNode=new Node(carry);
        //     curr.next=newNode;
        // }
        return head;
    }
}
