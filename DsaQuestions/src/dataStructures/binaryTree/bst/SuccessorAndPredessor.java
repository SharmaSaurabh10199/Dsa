package dataStructures.binaryTree.bst;

public class SuccessorAndPredessor {
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
    public TreeNode successor(TreeNode root, TreeNode p){
        TreeNode successor=null;
        if(root==null){
            return successor;
        }
        while (root!=null){
            if(root.val>p.val){
                successor=root;
                root=root.left;
            }
            else {
                // predessor = root;
                root=root.right;
            }
        }
        return successor;
    }
}
