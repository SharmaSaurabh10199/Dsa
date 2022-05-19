package dataStructures.queue;

public class Main {
    public static void main(String[] args) {
        QueueByLL q= new QueueByLL();
        System.out.println(q.isEmpty());
        System.out.println(q.getSize());
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.getSize());
        System.out.println(q.isEmpty());
        System.out.println(q.pollFront());
        System.out.println(q.getSize());
        q.print();
    }
}
