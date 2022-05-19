package dataStructures.binaryTree.postClass;

import java.util.ArrayList;

public class BoundryTraversal {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    void addLeft(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        while (!isLeafNode(root)){
            list.add(root.data);
            if(root.left!=null){
                root=root.left;
            }
            else {
                root=root.right;
            }
        }
    }
    void addRight(Node root,ArrayList<Integer> list ){
        if(root==null){
            return;
        }
        ArrayList<Integer> temp= new ArrayList<>();
        while (!isLeafNode(root)){
            temp.add(root.data);
            if(root.right!=null){
                root=root.right;
            }
            else {
                root=root.left;
            }
        }
        if(temp.size()>0){
            for (int i = temp.size()-1; i >=0 ; i--) {
                list.add(temp.get(i));
            }
        }
    }
    // to add the leaf nodes
    void addLeafs(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        addLeafs(root.left,list);
        if(isLeafNode(root)){
            list.add(root.data);
        }
        addLeafs(root.right,list);
    }
    ArrayList<Integer> boundary(Node node)
    {
        ArrayList<Integer> res= new ArrayList<>();
        if(!isLeafNode(node)) res.add(node.data);
        addLeft(node.left,res);
        addLeafs(node,res);
        addRight(node.right,res);
        return res;
    }

    boolean isLeafNode(Node root){
        return root.left==null && root.right==null;
    }
}
