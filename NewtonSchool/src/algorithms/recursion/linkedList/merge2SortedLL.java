package algorithms.recursion.linkedList;

public class merge2SortedLL {
    static class Node{
        int val;
        Node next;
        public Node (int val){
            this.val=val;
        }
    }
    public static Node merge(Node A,Node B){
        if(A==null){
            return B;
        }
        if(B==null){
            return A;
        }
        if(A.val<B.val){
            A.next=merge(A.next,B);
            return A;
        }
        else {
            B.next=merge(A,B.next);
            return B;

        }
    }

    public static void main(String[] args) {
        Node node= new Node(1);
        node.next=new Node(4);
        node.next.next=new Node(6);
        node.next.next.next=new Node(7);
        Node node2=new Node(0);
        node2.next=new Node(3);
        node2.next.next=new Node(5);
        merge(node,node2);


    }

}
