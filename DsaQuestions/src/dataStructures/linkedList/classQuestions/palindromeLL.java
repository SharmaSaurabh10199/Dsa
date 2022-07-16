package dataStructures.linkedList.classQuestions;

public class palindromeLL {
    static ListNode head;

    static class ListNode {

        int data;
        ListNode next;

        ListNode(int d)
        {
            data = d;
            next = null;
        }
    }
    void printList(RverseOfll.Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        palindromeLL list = new palindromeLL();

        list.head = new ListNode(1);
      //  list.head.next = new listNode(2);
      //  list.head.next.next = new listNode(1);
     //   list.head.next.next.next = new listNode(1);
        System.out.println(isaPalindrome(head));
    }
    public static boolean isaPalindrome(ListNode head){
        MidOfLL midd= new MidOfLL();
        middleOfLl(head);
        ListNode middle= middleOfLl(head);
        ListNode nextTomidle=middle.next;
        if(nextTomidle==null){
            return false;
        }
        middle.next=null;
        ListNode head2=reverseBypointer(nextTomidle);

        while (head!=null && head2!=null){

            if(head.data!=head2.data){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;

    }
    public static ListNode middleOfLl(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (  fast.next!=null && fast.next.next!=null){ // the codition for the left middle part will be fast.next.next!=null && fast.next!=null;
            slow=slow.next;
            fast=fast.next.next;

        }
        //System.out.println(slow.data);
        return slow;
    }
    public static ListNode reverseBypointer(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while (curr!=null){
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        head=prev;
        return prev;
    }
}
