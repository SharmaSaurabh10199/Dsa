package dataStructures.binaryTree.bst;

public class Lca {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val = data;
            left=null;
            right=null;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val>p.val  && root.val>q.val ){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;

    }
    // iterative solution
    public TreeNode lowestCommonAncestorIteative(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        while (root!=null){
            if(root.val>p.val  && root.val>q.val ){
                root=root.left;
            }
            else if(root.val<p.val && root.val<q.val){
                root=root.right;
            }
            else {
                return root;
            }
        }
        return root;
    }
}
