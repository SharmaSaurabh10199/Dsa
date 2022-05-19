package dataStructures.binaryTree.postClass;
/*
Given a Binary Tree of size N , where each node can have positive or negative values. Convert this to a tree where each node contains the sum of the left and right sub trees of the original tree. The values of leaf nodes are changed to 0.

Example 1:

Input:
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5

Output:
            20
          /    \
        4        12
       /  \     /  \
     0     0   0    0

Explanation:

           (4-2+12+6)
          /           \
      (8-4)          (7+5)
       /   \         /  \
 */
public class SumTree {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    public void toSumTree(Node root){
        //add code here.
        transform(root);
    }
    public int transform(Node root){
        if(root==null){
            return 0;
        }
        int left=transform(root.left);
        int right= transform(root.right);
        int curr= root.data;
        root.data=left+right;
        return left+right+curr;
    }

}
