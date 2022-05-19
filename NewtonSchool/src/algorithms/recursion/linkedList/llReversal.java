package algorithms.recursion.linkedList;

public class llReversal {
    static class Node{
        int val;
        Node next;
        public Node (int val){
            this.val=val;
        }
    }
    public Node reverse(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node rest=reverse(node.next);
        node.next.next=node;
        node.next=null;
        return rest;
    }

    public static void main(String[] args) {
        llReversal ll= new llReversal();
        Node node= new Node(1);
        node.next= new Node(2);
        node.next.next= new Node(3);
        node.next.next.next= new Node(4);
        ll.reverse(node);
    }
}
