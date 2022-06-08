package dataStructures.linkedList.homeWork;
/*
Two numbers are represented in Linked List such that each digit corresponds to a node in linked list.
Your task is to add these two numbers and return the sum in a linked list.

Note:-Linked list representaion of a number is from left to right i.e if the number is 123 than in
linked list it is represented as 3->2->1
 */
public class Add2LLs {
    static class ListNode {
        ListNode next;
        int data;

        ListNode(int data) {
            this.data = data;
            next = null;
        }
    }
    static ListNode addNumber(ListNode l1, ListNode l2) {
// return the head of the modified linked list
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode h3 = new ListNode(0);
        ListNode curr = h3;
        int sum = 0, carry = 0;
        while (h1 != null && h2 != null) {
            sum = h1.data + h2.data + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
            h1 = h1.next;
            h2 = h2.next;


        }
        while (h2 != null) {
            sum = h2.data + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
            h2 = h2.next;

        }
        while (h1 != null) {
            sum = h1.data + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
            h1 = h1.next;

        }
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }
        h3 = h3.next;
        return h3;
    }
}
