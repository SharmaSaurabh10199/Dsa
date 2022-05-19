package dataStructures.linkedList;

public  class LinkedList<H> {
    private class Node {
         int data;
         Node next;
        public Node(int data){
            this.data=data;
        }
    }
     int size;
     Node head;
     public LinkedList(){
        this.size=0;
    }
     public void add(int data){
         Node node= new Node(data);
         if(this.head==null){
           this.head=node;
           //head.next=null;
        }
         else {
           Node i= this.head;
           while (i.next!=null){
               i=i.next;
           }
           i.next=node;
           //node.next=null;
        }
       this.size++;
    }
    public int remove(){
        if(this.head==null){
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        }
        else if(this.size==1){
            int retuendata = this.head.data;
            this.head=null;
            this.size--;
            return retuendata;
        }
        Node secondLast= this.head;
        int i=0;
        while (i<this.size-2){
            i++;
            secondLast=secondLast.next;
        }
        int returndata=secondLast.next.data;
        secondLast.next=null;
        this.size--;
        return returndata;
    }
    public void addhead(int data){
        Node newNode= new Node(data);
        if(this.head==null){
            this.head=newNode;
            this.head.next=null;
        }
        else {
            Node prevHead= this.head;
            this.head=newNode;
            this.head.next=prevHead;
        }
     this.size++;
    }
    public int  removeHead(){
        if(this.head==null){
            System.out.println("empthy list");
            return Integer.MIN_VALUE;
        }
        int data= this.head.data;
        this.head=this.head.next;
        this.size--;
        return data;
    }
    public int getSize(){
        return this.size;
    }
    public void updateAtIndex(int idx, int data){
        if(idx<0 || idx>=this.size){
            System.out.println("invalid index");
            return;
        }
        int i=0;
        Node nodeToUpdata=this.head;
        while (i<idx){
            nodeToUpdata=nodeToUpdata.next;
            i++;
        }
        nodeToUpdata.data=data;
    }
    public void insertNode(int idx, int data){
        if(idx<0 || idx>=this.size){
            System.out.println("invalid index");
            return;
        }

        if(idx==0){
            addhead(data);
        }
        else if(idx==this.size-1){
            add(data);
        }
        else {
            Node nodeToAdd= new Node(data);
            Node itetrator= this.head;
            int i=0;
            while (i<idx-1){
                i++;
                itetrator=itetrator.next;
            }
            nodeToAdd.next=itetrator.next;
            itetrator.next=nodeToAdd;
            this.size++;
        }
    }
    // to be asked from mentor.

    public void print(){
        Node i= this.head;
        i=null;
        while (head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println("null");
    }
}
