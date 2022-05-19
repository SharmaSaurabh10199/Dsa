package dataStructures.binaryTree.bst;

public class BstFromPreOrder {
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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }
    TreeNode build(int[] preorder,int bound){
        if(i==preorder.length || preorder[i]>bound){
            return null;
        }
        TreeNode node= new TreeNode(preorder[i++]);

        node.left=build(preorder,node.val);
        node.right=build(preorder,bound);
        return node;
    }
}
