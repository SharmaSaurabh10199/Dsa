package dataStructures.binaryTree.bst;

public class FloorAndCeil {
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
    public void floorAndCeil(TreeNode root, int val){
        int floor=-1,ceil=-1;
        while (root!=null){
            if(root.val==val){
                floor=val;
                ceil=val;
                break;
            }
            else if(root.val>val){
                ceil=root.val;
                root=root.left;
            }
            else {
                floor=root.val;
                root=root.right;
            }
        }
        System.out.println(floor+"  "+ceil);
    }
}
