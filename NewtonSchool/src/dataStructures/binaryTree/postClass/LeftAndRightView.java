package dataStructures.binaryTree.postClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LeftAndRightView {
    class Node
    {
        int data;
        Node left, right;
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        ArrayList<Integer> list= new ArrayList<>();
        if(node==null){
            return list;
        }
        rightView(list,node,0);
        return list;

    }
    // recursive right view
    void rightView(ArrayList<Integer> list,Node root, int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        rightView(list,root.right,level+1);
        rightView(list,root.left,level+1);
    }
    // recursive left view
    void leftView(ArrayList<Integer> list,Node root, int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        rightView(list,root.left,level+1);
        rightView(list,root.right,level+1);

    }

    // level order solution
    ArrayList<Integer> rightViewByLevel(Node node) {
        //add code here.
        ArrayList<Integer> list= new ArrayList<>();
        if(node==null){
            return list;
        }
        Deque<Node> dq= new ArrayDeque<>();
        dq.add(node);
        while (!dq.isEmpty()){
            int n= dq.size();
            for (int i = 0; i < n; i++) {
                Node temp= dq.poll();
                // for left view, i=0.
                if(i==n-1){
                    list.add(temp.data);
                }
                if(temp.left!=null){
                    dq.add(temp.left);
                }
                if(temp.right!=null){
                    dq.add(temp.right);
                }
            }
        }
        return list;
    }



}
