package dataStructures.stacks;

public class StacksByArrays  {
    private int[] container;
    private int size;
    public int capacity;
    public StacksByArrays(int capacity){
        this.capacity=capacity;
        container= new int[capacity];
        this.size=0;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void push(int data){
        if((this.size/capacity)*100>80){
            resize();
        }
        container[size++]=data;
    }
    public int peek(){
        if(this.isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return container[this.size-1];
    }
    public int pop(){
        if(this.isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        this.size--;
        return container[size];
    }
    public  void print(){
        if(size==0){
            System.out.println("empty stack");
        }
        else {
            for (int i = size-1; i >=0; i--) {
                System.out.print(container[i]+" ");
            }
            System.out.println();
        }
    }
    public void resize(){
        //this.capacity=2*this.capacity;
        int[] temp= new int[2*this.capacity];
        for (int i = 0; i < this.size; i++) {
            temp[i]=container[i];
        }
        this.container=temp;
    }
}
