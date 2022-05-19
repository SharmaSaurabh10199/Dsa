package dataStructures.linkedList.homeWork;

/*
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
 */
/*
Solution: approach1:  1) create an array of same size and copy its elements to array:
                      2) sort the array using merge sort and copy it back to linked list;
                      this doesn't seem to e proper solution cause you're not learning something new.
          approach2: 1) divide the linked lists in sublists and merge then with divide and conquer
                       algorithm.
 */
public class
MergeSortForll {
    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            this.data = key;
            next = null;
        }
    }
    // using extra space array
//    public static Node mergeSortForLl(Node head){
//        Node curr=head;
//        Node curr2=head;
//        int size=0;
//        while (curr!=null){
//            size++;
//            curr=curr.next;
//        }
//
//        int[] arr= new int[size];
//        for (int i = 0; i < size; i++) {
//            arr[i]=curr2.data;
//            curr2=curr2.next;
//        }
//        mergeSort(arr,0,size-1);
//        Node curr3=head;
//        for (int i = 0; i < size; i++) {
//            curr3.data=arr[i];
//            curr3=curr3.next;
//        }
//        return head;
//
//    }
//    public static void mergeSort(int[] arr, int p, int r){
//        if(p<r){
//            int q=(p+r)/2;
//            mergeSort(arr,p,q);
//            mergeSort(arr,q+1,r);
//            merge(arr,p,q,r);
//        }
//    }
//    public static void merge(int[] arr, int p, int q, int r){
//        int n1= q-p+1;
//        int n2= r-q;
//        int l=0,j=0;
//        int[] L= new int[n1+1];
//        int[] R = new int[n2+1];
//        for (int i = 0; i < n1; i++) {
//            L[i]=arr[p+i];
//        }
//        for (int i = 0; i < n2; i++) {
//            R[i]=arr[q+1+i];
//        }
//        L[n1]=Integer.MAX_VALUE;
//        R[n2]=Integer.MAX_VALUE;
//        for(int k=p; k<=r; k++){
//            if(L[l]<R[j]){
//                arr[k]=L[l];
//                l++;
//            }
//            else{
//                arr[k]=R[j];
//                j++;
//
//            }
//        }
//    }
  //-------------------------------------------------------------------------------------------
    public static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node middle=findMiddle(head);
        //Node head1=head;
        Node head2=middle.next;
        middle.next=null;
        Node newHead1=mergeSort(head);
        Node newHead2=mergeSort(head2);
        Node finalNode=merge(newHead1,newHead2);
        return finalNode;
    }
    public static Node findMiddle(Node head){
        Node slow=head;
        Node fast=head;
        while (fast.next!=null && fast.next.next!=null){ // the codition for the left middle part will be fast.next.next!=null && fast.next!=null;
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node merge(Node node1,Node node2){
//        Node dummyNode=new Node(-1);
//        Node curr=dummyNode;
//        while (node1!=null && node2!=null){
//            if(node1.data<node2.data){
//                Node node=new Node(node1.data);
//                curr.next=node;
//                curr=curr.next;
//                node1=node1.next;
//            }
//            else {
//                Node node=new Node(node2.data);
//                curr.next=node;
//                curr=curr.next;
//                node2=node2.next;
//
//            }
//        }
//        while (node1!=null){
//            Node node=new Node(node1.data);
//            curr.next=node;
//            curr=curr.next;
//            node1=node1.next;
//
//        }
//        while (node2!=null){
//            Node node=new Node(node2.data);
//            curr.next=node;
//            curr=curr.next;
//            node2=node2.next;
//
//        }
//        return dummyNode.next;
        //--------------------------------------------
        // better in place recursive approach
        if(node1==null){
            return node1;
        }
        if(node2==null){
            return node1;
        }
        if(node1.data<node2.data){
            node1.next=merge(node1.next,node2);
            return node1;
        }
        else {
            node2.next=merge(node1,node2.next);
            return node2;

        }
    }

}
