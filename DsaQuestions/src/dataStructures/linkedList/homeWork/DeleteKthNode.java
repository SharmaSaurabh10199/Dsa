package dataStructures.linkedList.homeWork;
/*
Given a linked list consisting of N nodes, your task is to delete every kth Node from the circular linked
list until only one node is left. Also, print the intermediate lists

Sample Input:-
4 2
1 2 3 4

Sample Output:-
1->2->3->4->1
1->2->4->1
2->4->2
2->2
 */
public class DeleteKthNode {
    class Node
    {
        int data;
        Node next;
        Node(int x)
        {
            data = x;
            next = null;
        }
    }
    public Node  deleteKthNode(Node head,int k){
        if(head==null){
            return null;
        }
        Node curr=head;
        Node prev=null;
        while (curr.next!=curr){

            // if(curr==head && curr.next==head){
            //     break;
            // }
            print(head);
            for (int i = 0; i < k; i++) {
                prev=curr;
                curr=curr.next;
            }
            if(head==curr){
                head=head.next;
            }
            // curr=curr.next;
            prev.next=curr.next;
        }
        return head;

    }
    public static void print(Node node){
        System.out.println(node.data);
        node=node.next;
        while (node!=node){
            System.out.println(node.data);
        }
        System.out.println(node.data);
    }
}
