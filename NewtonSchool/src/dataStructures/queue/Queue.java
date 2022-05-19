package dataStructures.queue;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Integer> data;
    private int size;
    private int front;
    Queue(){
        this.data=new ArrayList<>();
        this.size=0;
        this.front=0;
    }
    public void enQueue(int val){
        this.data.add(val);
        this.size++;
    }
    public int remove(){
        if(this.size==0){
            System.out.println("empty queue");
            return -1;
        }
        int data=this.data.remove(this.front);
        this.front++;
        this.size--;
        return data;
    }
    public int peek(){
        if(this.size==0){
            System.out.println("empty queue");
            return -1;
        }
        return this.data.get(this.front);
    }
    public int getSize(){
        return this.size;
    }

}
