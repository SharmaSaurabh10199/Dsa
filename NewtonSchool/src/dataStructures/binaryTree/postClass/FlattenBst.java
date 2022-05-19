package dataStructures.binaryTree.postClass;

public class FlattenBst {
    static Node prev;
    public Node flatten(Node root){
        Node dummy= new Node(-1);
        prev=dummy;
        inOrder(root);
        prev.right=null;
        prev.left=null;
        return dummy.right;

    }
    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        prev.right=root;
        prev.left=null;
        prev=root;
        inOrder(root.right);
    }
}
