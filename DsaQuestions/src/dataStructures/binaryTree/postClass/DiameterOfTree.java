package dataStructures.binaryTree.postClass;

public class DiameterOfTree {
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
    static int dia=0;
    // o(n2) approach
    int diaMeter(Node root){
        if(root==null)return 0;
        int lh= maxHeight(root.left);
        int rh= maxHeight(root.right);
        dia=Math.max(dia,lh+rh);
        diaMeter(root.left);
        diaMeter(root.right);
        return dia;
    }
    // for calculating height
    int maxHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=maxHeight(root.left);
        int rightHeight=maxHeight(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
    // 0(n) optimized approach
    int height(Node root){
        if(root==null){
            return 0;
        }
        int left= height(root.left);
        int right= height(root.right);
        dia=Math.max(dia,left+right);
        return 1+Math.max(left,right);
    }
}
