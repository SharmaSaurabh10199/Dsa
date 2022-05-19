package dataStructures.binaryTree.bst;

import sun.reflect.generics.tree.Tree;

public class InsertNode {
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
    // iterative solution
    public TreeNode insertIntoBST(TreeNode root, int val) {
//        TreeNode r= root;
//        TreeNode node = new TreeNode(val);
//        if(root==null){
//            return node;
//        }
//        TreeNode prev= null;
//        while (root!=null){
//            prev=root;
//            if(root.val<val) root=root.right;
//            else root=root.left;
//        }
//        if(prev.val<val) prev.right=node;
//        else prev.left=node;
//        return r;
        //----------------------
        // without using prev node:
        TreeNode curr= root;
        TreeNode newNode = new TreeNode(val);
        if(root==null){
            return newNode;
        }
        while (true){
            if(curr.val<val){
                if(curr.right!=null){
                    curr=curr.right;
                }
                else {
                    curr.right=newNode;
                    break;
                }
            }
            else {
                if(curr.left!=null){
                    curr=curr.left;
                }
                else {
                    curr.left=newNode;
                    break;
                }
            }
        }
        return root;
    }
    // recursive solution
    TreeNode insertNode(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
             root.left= insertNode(root.left,val);
        }
        else {
             root.right= insertNode(root.right,val);
        }
        return root;
    }


}
