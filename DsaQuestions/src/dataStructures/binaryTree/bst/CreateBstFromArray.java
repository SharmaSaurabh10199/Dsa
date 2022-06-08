package dataStructures.binaryTree.bst;

import sun.reflect.generics.tree.Tree;

public class CreateBstFromArray {
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

    public static void main(String[] args) {
        int[] arr={4,5,6,2,10};
        TreeNode root= null;
        
        for (int i = 0; i < arr.length; i++) {
            root=insertNode(root,arr[i]);
        }
    }
    static TreeNode insertNode(TreeNode root, int val){
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
