package dataStructures.stacks;

public class StackByLL {
    class Node{
        Node next;
        int data;
        public Node(int data){
            this.data=data;
        }
    }
    private int size;
    private Node top;
    public StackByLL(){
        this.size=0;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public int peek(){
        if(this.isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return top.data;
    }
    public void push(int data){
        Node newNode= new Node(data);
        Node oldTop=top;
        newNode.next=oldTop;
        this.size++;
        top=newNode;
    }
    public Node pop(){
        if(top==null){
            return null;
        }
        Node nodeToReturn=this.top;
        this.top=this.top.next;
        this.size--;
        return nodeToReturn;
    }
    public void print(){
        Node node=this.top;
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.print("null");
        System.out.println();
    }

}
