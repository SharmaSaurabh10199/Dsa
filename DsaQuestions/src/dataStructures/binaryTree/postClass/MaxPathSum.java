package dataStructures.binaryTree.postClass;

public class MaxPathSum {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    int maxSum=Integer.MIN_VALUE;
    int MaxPathSum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum= Math.max(0,MaxPathSum(root.left));
        int rightSum= Math.max(0,MaxPathSum(root.right));
        maxSum= Math.max(maxSum,root.data+leftSum+rightSum);
        return root.data+Math.max(leftSum,rightSum);
    }
}
