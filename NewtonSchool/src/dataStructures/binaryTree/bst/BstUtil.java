package dataStructures.binaryTree.bst;
class Node{
    int val;
    Node left;
    Node right;
    Node parent;
    public Node(int val){
        this.val=val;
    }
}

public class BstUtil {

    public Node search(Node root, int key){
        if(root==null || root.val==key){
            return root;
        }
        if(root.val<key){
            return search(root.right,key);
        }
        return search(root.left,key);
    }
    public Node min(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public Node max(Node root){
        while (root.right!=null){
            root=root.right;
        }
        return root;
    }
    public Node successor(Node x){
        if(x.right!=null){
            return min(x.right);
        }
        Node y=x.parent;
        while (y!=null && y.right==x){
            x=y;
            y= y.parent;
        }
        return y;
    }
    public Node predecessor(Node x){
        if(x.left!=null){
            return max(x.left);
        }
        Node y= x.parent;
        while (y!=null && y.left==x){
            x=y;
            y= y.parent;
        }
        return y;
    }
}
