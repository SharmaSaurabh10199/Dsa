package dataStructures.linkedList.homeWork;

/*
Given two sorted linked lists consisting of N and M nodes respectively.
The task is to merge both of the list (in-place) and return head of the merged list.


Example 1:

Input:
N = 4, M = 3
valueN[] = {5,10,15,40}
valueM[] = {2,3,20}
Output: 2 3 5 10 15 20 40
Explanation: After merging the two linked
lists, we have merged list as 2, 3, 5,
10, 15, 20, 40.
 */
public class MergeSortedLL {
    static Node head;
    static class Node
    {
        int val;
        Node next;
        Node(int d) {val = d; next = null; }
    }
    static void  printList(Node node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static Node MergeSortedLLs(Node node1, Node node2){
//        Node merge= node1.val< node2.val? node1 : node2;
//        Node res=merge;
//        Node itr1=null,itr2=null;
//        if(merge== node1){
//             itr1= node1.next;
//             itr2= node2;
//        }
//        else {
//             itr1= node1;
//             itr2= node2.next;
//        }
//        while (itr1!=null && itr2!=null){
//            if(itr1.val< itr2.val){
//                merge.next=itr1;
//                itr1=itr1.next;
//                merge=merge.next;
//            }
//            else {
//                merge.next=itr2;
//                itr2=itr2.next;
//                merge=merge.next;
//            }
//        }
//        while (itr1!=null){
//            merge.next=itr1;
//            itr1=itr1.next;
//            merge=merge.next;
//        }
//        while (itr2!=null){
//            merge.next=itr2;
//            itr2=itr2.next;
//            merge=merge.next;
//        }
//        return res;
        //-------------------------------------------------
        //better recursive approach
        if(node1==null){
            return node1;
        }
        if(node2==null){
            return node1;
        }
        if(node1.val<node2.val){
            node1.next= MergeSortedLLs(node1.next,node2);
            return node1;
        }
        else {
            node2.next=MergeSortedLLs(node1,node2.next);
            return node2;

        }
    }


}
