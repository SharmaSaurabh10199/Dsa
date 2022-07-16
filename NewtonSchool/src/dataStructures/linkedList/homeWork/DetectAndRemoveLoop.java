package dataStructures.linkedList.homeWork;
/*
Given a linked list of N nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present.


Example 1:

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|
A loop is present. If you remove it
successfully, the answer will be 1.
 */
public class
DetectAndRemoveLoop {
    class Node
    {
        int data;
        Node next;
    }
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
//        boolean loopExists=false;
//        Node slow=head;
//        Node fast=head;
//        Node prev=head;
//        while(fast!=null){
//            slow=slow.next;
        //     prev=fast;
//            fast=fast.next.next;
//            if(slow==fast){
//                loopExists=true;
//                break;
//            }
//
//        }
//        if(loopExists==true){
//            prev=prev.next;
//            slow=head;
//            while (fast!=slow){
//                slow=slow.next;
//                prev=fast;
//                fast=fast.next;
//            }
//            prev.next=null;
//        }

            // code here
            // remove the loop without losing any nodes
            boolean loopExists=false;
            Node slow=head;
            Node fast=head;

            while(fast!=null&& fast.next!=null){
                slow=slow.next;

                fast=fast.next.next;
                if(slow==fast){
                    loopExists=true;
                    break;
                }

            }

            if(loopExists==true){

                slow=head;
                // Node prev=fast;
                if(slow!=fast){
                    while (fast.next!=slow.next){
                        slow=slow.next;
                        fast=fast.next;
                    }
                    fast.next=null;
                }
                else{
                    while(fast.next!=slow){
                        fast=fast.next;
                    }
                    fast.next=null;
                }
            }
    }
}
