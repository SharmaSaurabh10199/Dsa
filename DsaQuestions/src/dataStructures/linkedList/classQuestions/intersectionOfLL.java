package dataStructures.linkedList.classQuestions;

public class intersectionOfLL {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

      int sizeA=getSize(headA);
      int sizeB=getSize(headB);
      int initialSteps=Math.abs(sizeA-sizeB);
      ListNode a=headA;
      ListNode b=headB;
      while (initialSteps>0){
          if(sizeA>sizeB){
             a=a.next;
          }
          else {
            b=b.next;
          }
          initialSteps--;
      }
      while (a!=b){
          a=a.next;
          b=b.next;
      }
      return a;

    }
    public static int getSize(ListNode node){
        int size=0;
        while (node!=null){
            size++;
        }
        return size;
    }
}
