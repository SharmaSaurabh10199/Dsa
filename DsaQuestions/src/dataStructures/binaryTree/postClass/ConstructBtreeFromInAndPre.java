package dataStructures.binaryTree.postClass;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

public class ConstructBtreeFromInAndPre {
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
        int[] postorder={9,15,7,20,3};
        int[] inorder= {9,3,15,20,7};
        ConstructBtreeFromInAndPre c= new ConstructBtreeFromInAndPre();
       // c.buildTree(preorder,inorder);
        c.buildTreeFromPostAndIn(inorder,postorder);



    }
    public TreeNode buildTreeFromPreAndIn(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i],i);
        }
        return buildtree(inorder,preorder,0,inorder.length-1,0,preorder.length-1,hm);

    }
    TreeNode buildtree(int[] inorder,int[] preorder,int inStart,int inEnd,int preStart,int preEnd,HashMap<Integer,Integer> hm){
        if(inStart>inEnd || preStart>preEnd){
            return null;
        }
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRoot= hm.get(preorder[preStart]);
        root.left= buildtree(inorder,preorder,inStart,inRoot-1,preStart+1,preStart+(inRoot-inStart),hm);
        root.right= buildtree(inorder,preorder,inRoot+1,inEnd,preStart+(inRoot-inStart)+1,preEnd,hm);
        return root;
    }
    // from post order and inorder
    TreeNode buildTreeFromPostAndIn(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1,hm);

    }
    TreeNode buildTree(int[] inorder,int[] postorder,int inStart,int inEnd,int postStart,int postEnd,HashMap<Integer,Integer>hm){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }
        TreeNode root= new TreeNode(postorder[postEnd]);
        int inRoot= hm.get(root.val);
        root.left=buildTree(inorder,postorder,inStart,inRoot-1,postStart,postStart+(inRoot-inStart)-1,hm);
        root.right=buildTree(inorder,postorder,inRoot+1,inEnd,postStart+(inRoot-inStart),postEnd-1,hm);
        return root;
    }
}
