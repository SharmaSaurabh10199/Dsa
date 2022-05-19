package dataStructures.queue;

public class QueueByLL {
    private class Node{
        Node next;
        int data;
        public Node(int data){
            this.data=data;
        }
    }

    private int size;
    private Node head;
    private Node tail;
    public QueueByLL(){
        this.size=0;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else {
            Node oldTail=this.tail;
            oldTail.next=newNode;
            this.tail=newNode;
        }
        this.size++;
    }
    public int pollFront(){
        if(this.isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        Node oldHead=this.head;
        int dataToReturn= oldHead.data;
        this.head=this.head.next;
        this.size--;
        oldHead=null;
        return dataToReturn;

    }
    public void pushFront(int data){
        Node newNode = new Node(data);
        if(head==null){
            newNode=head;
            head=tail;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        this.size++;
    }
    public void print(){
        Node node= this.head;
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.print("null");
        System.out.println();
    }

}
