package dataStructures.binaryTree.postClass;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxHeightOfTree {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
    // using recursion
    public int maxHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=maxHeight(root.left);
        int rightHeight=maxHeight(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
    // using level order traversal
    public int maxHeightByIteration(Node node){
        if(node==null){
            return 0;
        }
        int level=0;
        Deque<Node > dq= new ArrayDeque<>();
        dq.add(node);
        while (!dq.isEmpty()){
            int n= dq.size();
            level++;
            for (int i = 0; i < n; i++) {
                Node temp=dq.poll();
                if(temp.left!=null){
                    dq.add(temp.left);
                }
                if(temp.right!=null){
                    dq.add(temp.right);
                }
            }

        }
        return level;

    }
}
