package dataStructures.linkedList.homeWork;
/*
Example 1:
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
Input:
5 -> 10 -> 19 -> 28
|     |     |     |
7     20    22   35
|           |     |
8          50    40
|                 |
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
 */
public class FlanttenaLL {
    class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    Node flatten(Node root)
    {
        // Your code here
        if(root==null|| root.next==null){
            return root;
        }
        root.next=flatten(root.next);
        root=merge(root,root.next);

     return root;
    }
    Node merge(Node node1,Node node2){
//        Node res=new Node(-1);
//        Node curr=res;
//        while(node1!=null && node2!= null){
//            if(node1.data<node2.data){
//                curr.bottom=node1;
//                node1=node1.bottom;
//                curr=curr.bottom;
//            }
//            else {
//                curr.bottom=node2;
//                node2=node2.bottom;
//                curr=curr.bottom;
//            }
//        }
//        if(node1!=null){
//            curr.bottom=node1;
//        }
//        else {
//            curr.bottom=node2;
//        }
//        res=res.bottom;
//        res.next=null;
//        return res;
        if(node1==null){
            return node1;
        }
        if(node2==null){
            return node1;
        }
        if(node1.data<node2.data){
            node1.bottom=merge(node1.bottom,node2);
            return node1;
        }
        else {
            node2.bottom=merge(node1,node2.bottom);
            return node2;
        }
    }
}
