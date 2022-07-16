package dataStructures.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeIncludes {
    static  public class Node {
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    //
    public boolean exist(Node  node, int key){
        if(node==null){
            //System.out.println("empty tree");
            return false;
        }
        Deque<Node> dq= new ArrayDeque<>();
        dq.addLast(node);
        while(!dq.isEmpty()){
            Node curr= dq.pollFirst();
            if(curr.val==key){
                return true;
            }
            //System.out.println(curr.val);
            if(curr.left!=null){
                dq.addLast(curr.left);
            }
            if(curr.right!=null){
                dq.addLast(curr.right);
            }
        }
        return false;
    }
    // recursive method
    public boolean exists(Node node, int key){
        if(node==null){
            return false;
        }
        if(node.val==key){
            return true;
        }
        return exists(node.left, key) || exists(node.right,key);
    }
}
