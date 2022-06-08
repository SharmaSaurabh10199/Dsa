package dataStructures.binaryTree.postClass;

public class BalancedTree {
    static public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public int height(Node root){
        if(root==null){
            return 0;
        }
        int left= height(root.left);
        int right= height(root.right);
        return 1+Math.max(left,right);
    }
    // o(n2) approach
    boolean isBalanced(Node root)
    {
        // Your code here
        if(root==null){
            return true;
        }
        int leftHeight=height(root.left);
        int rightHeight= height(root.right);
        int val=Math.abs(leftHeight-rightHeight);
        if(val>1){
            return false;
        }
        boolean left= isBalanced(root.left);
        boolean right= isBalanced(root.right);
        if(left == false || right == false){
            return false;
        }
        return true;
    }

    // o(n) approach
    boolean isTreeBalanced(Node root){
        return heightOfTree(root)!=-1;
    }
    int heightOfTree(Node root){
        if(root==null){
            return 0;
        }
        int left= heightOfTree(root.left);
        int right= heightOfTree(root.right);
        //  here while calculating height, we are also chechking if the tree is unbalanced, if it is. we are directly returning
        // -1;
        if(left==-1 || right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return 1+Math.max(left,right);

    }
}
