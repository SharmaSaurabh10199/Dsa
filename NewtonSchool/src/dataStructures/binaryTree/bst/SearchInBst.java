package dataStructures.binaryTree.bst;

public class SearchInBst {
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
    // iterative search
    public TreeNode searchBST(TreeNode root, int val) {
        while (root!=null){
            if(root.val ==val){
                return root;
            }
            else if(root.val>val){
                root=root.left;
            }
            else {
                root=root.right;
            }
        }
        return root;
    }
    // recursive search
    public TreeNode searchBst(TreeNode root, int val){
        if(root==null || root.val==val){
            return root;
        }
        if(root.val>val){
            return searchBst(root.left,val);
        }
        return searchBst(root.right,val);
    }
}
