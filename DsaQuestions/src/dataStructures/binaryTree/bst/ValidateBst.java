package dataStructures.binaryTree.bst;

import sun.reflect.generics.tree.Tree;

public class ValidateBst {
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
    // one approach could be, do inorder traversal, if its not in sorted order, return false. thats a naive
    // solution
    public boolean isValidBST(TreeNode root) {
        return validBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean validBst(TreeNode root, int minVal,int maxVal){
        if(root==null){
            return true;
        }
        if(root.val<minVal || root.val>maxVal){
            return false;
        }
        return validBst(root.left,minVal, root.val) && validBst(root.right,root.val,maxVal);
    }
}
