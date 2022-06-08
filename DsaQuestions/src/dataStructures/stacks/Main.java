package dataStructures.stacks;

public class Main {
    public static void main(String[] args) {
//        StackByLL stack= new StackByLL();
//        System.out.println(stack.pop());
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.print();
//        System.out.println(stack.peek());
        checkStacksByArrays();

    }
    public static void checkStacksByArrays(){
        StacksByArrays stack= new StacksByArrays(6);
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
}
