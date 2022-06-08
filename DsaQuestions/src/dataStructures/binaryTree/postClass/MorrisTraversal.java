package dataStructures.binaryTree.postClass;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list= new ArrayList<>();
        TreeNode curr=root;
        while (curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }
            else {
                TreeNode prev= curr.left;
                while (prev.right!=null && prev.right!=curr ){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    // list.add(curr.val) for preorder
                    curr=curr.left;
                }
                else {
                    prev.right=null;
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}
