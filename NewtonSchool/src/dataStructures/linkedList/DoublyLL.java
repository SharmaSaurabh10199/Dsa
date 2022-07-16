package dataStructures.linkedList;

public class
DoublyLL {
    class Node{
        Node next;
        Node prev;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    Node head;
    int size;
    DoublyLL(){
        this.size=0;
    }
    public Node  addFirst(int k){
        Node newNode= new Node(k);
        newNode.next=head;
        if(head!=null){
            head.prev=newNode;
        }
        head=newNode;
        this.size++;
        return head;
    }
    // indexing from 1
    public Node insertAt(int k, int p){
        if(p==1){
            return addFirst(k);
        }
        Node newNode= new Node(k);
        Node curr=head;
        while (p>2){
            curr=curr.next;
            p--;
        }
        Node next=curr.next;
        newNode.next=next;
        curr.next=newNode;
        newNode.prev=curr;
        next.prev=newNode;
        this.size++;
        return head;
    }
    public Node findKthFromLast(int k, Node head){
        Node slow=head;
        Node fast=head;
        while (k>0){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public void deletion(Node node){
        Node pre=node.prev;
        Node nxt=node.next;
        if(pre!=null) pre.next=nxt;
        if(nxt!=null) nxt.prev=pre;
        this.size--;
    }
    public Node deletionKFromlast(Node head, int k){
        Node nodeToDelete= findKthFromLast(k,head);
        Node next=head.next;
        deletion(nodeToDelete);
        return nodeToDelete==head?next:head;
    }
    public Node reverse(Node head){
        Node p=null,c=head;
        Node n;
        while (c!=null){
            n=c.next;
            c.next=p;
            c.prev=n;
            p=c;
            c=n;
        }
        return p;
    }
    public void display(Node node ){
        while (node!=null){
            System.out.println(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }
}
