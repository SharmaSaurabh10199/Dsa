package dataStructures.binaryTree.postClass;

public class BinaryToDll {
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
    // the processing takes place in inorder traversal
    static Node prev=null,head=null;
    public void  btreeToDll(Node root){
        if(root==null){
            return ;
        }
        btreeToDll(root.left);
        if(prev==null){
            head=root;
        }
        else {
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        btreeToDll(root.right);
    }
}
