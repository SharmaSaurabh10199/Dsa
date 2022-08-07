package dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
       LinkedList<Integer> ll= new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.print();
        ll.insertNode(5,6);
        ll.print();

//        System.out.println(ll.getSize());
        //System.out.println(ll.remove());
//        ll.print();
//        ll.add(6);
//        ll.print();
//        System.out.println(ll.getSize());
//          ll.remove();
//          ll.removeHead();
//        System.out.println(ll.getSize());
       // ll.addhead(0);

       // System.out.println(ll.getSize());
      //  ll.updateAtIndex(0,9);
//        ll.insertNode(3,9);
//        ll.print();
       // System.out.println(ll.head);

    }
    public static void check(){
        LinkedList<Integer> ll= new LinkedList<>();
        ll.add(4);
    }
}
