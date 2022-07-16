package dataStructures.binaryTree.bst;

import javax.swing.tree.TreeNode;


public class RecoverBst {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val = data;
            left=null;
            right=null;
        }
    }
    TreeNode first=null,prev=null,middle=null,last=null;
    public void recoverTree(TreeNode root) {
        Inorder(root);
        if(last!=null){
            swap(first,last);
        }
        else {
            swap(first,middle);
        }

    }
    public void swap(TreeNode node1,TreeNode node2){
        int temp= node1.val;
        node1.val=node2.val;
        node2.val=temp;
    }
    public void Inorder(TreeNode root){
        if(root==null){
            return;
        }
        Inorder(root.left);
        if(prev!=null && root.val< prev.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            else {
                last= root;
            }
        }
        prev=root;
        Inorder(root.right);
    }
}
