package dataStructures.linkedList.homeWork;

import java.util.ArrayList;

//    Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together and all even positions node are together.
//    Assume the first element to be at position 1 followed by second element at position 2 and so on.
//            Note: You should place all odd positioned nodes first and then the even positioned ones. (considering 1 based indexing). Also, the relative order of odd positioned nodes and even positioned nodes should be maintained.
//
//    Example 1:
//
//    Input:
//    LinkedList: 1->2->3->4
//    Output: 1 3 2 4
//    Explanation:
//    Odd elements are 1, 3 and even elements are
//2, 4. Hence, resultant linked list is
//1->3->2->4.
public class RearrangeLL {
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // without extra space, just rearranging the links;
     Node rearrange(Node head) {
         Node odd = head;
         Node even = head.next;
         Node evenHead = even;
         while (even != null && even.next != null) {
             odd.next = even.next;
             even.next = even.next.next;
             odd = odd.next;
             even = even.next;
         }
         odd.next = evenHead;

         return head;
     }
     // storing the data of odd and even in diff lists, and then adding it back to linked list;
     void rearrangeWithExtraSpace(Node head){
         //  The task is to complete this method
         ArrayList<Integer> even= new ArrayList();
         ArrayList<Integer> odd= new ArrayList();
         Node curr=head;
         int k=1;
         while(curr!=null){
             if(k%2==0){
                 even.add(curr.data);
             }
             else{
                 odd.add(curr.data);
             }
             curr=curr.next;
             k++;

         }
         Node curr2=head;
         int i=0,j=0;
         while(curr2!=null){
             if(i<odd.size()){
                 curr2.data=odd.get(i);
                 curr2=curr2.next;
                 i++;
             }
             else{
                 curr2.data=even.get(j);
                 curr2=curr2.next;
                 j++;

             }
         }
     }

}
