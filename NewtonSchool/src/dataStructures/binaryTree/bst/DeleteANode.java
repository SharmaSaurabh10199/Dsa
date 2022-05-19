package dataStructures.binaryTree.bst;

import sun.reflect.generics.tree.Tree;

public class DeleteANode {
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        TreeNode curr=root;
        if(curr.val==key){
            return reConstruct(root);
        }
        while (curr!=null){
            if(curr.val>key){
                if(curr.left!=null && curr.left.val==key){
                    curr.left=reConstruct(curr.left);
                }
                else {
                    curr=curr.left;
                }
            }
            else {
                if(curr.right!=null && curr.right.val==key){
                    curr.right=reConstruct(curr.right);
                }
                else {
                    curr=curr.right;
                }
            }
        }
        return root;
    }
    TreeNode reConstruct(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        else {
            TreeNode rightChild= root.right;
            TreeNode predecor= nodeToConnectTo(root.left);
            predecor.right=rightChild;
            return root.left;
        }

    }
    TreeNode nodeToConnectTo(TreeNode root){
        while (root.right!=null){
            root=root.right;
        }
        return root;
    }
}
