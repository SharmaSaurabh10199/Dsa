package dataStructures.binaryTree.postClass;
// in complete binary tree.
public class CountNodes {
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left= leftHeight(root);
        int right= rightHeight(root);
        if(left==right) return (int) (Math.pow(2,left)-1);
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int leftHeight(TreeNode root){
        int count=0;
        while (root!=null){
            root=root.left;
            count++;
        }
        return count;
    }
    int rightHeight(TreeNode root){
        int count=0;
        while (root!=null){
            root=root.right;
            count++;
        }
        return count;
    }
}
