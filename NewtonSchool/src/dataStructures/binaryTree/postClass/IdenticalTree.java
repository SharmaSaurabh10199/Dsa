package dataStructures.binaryTree.postClass;
/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true

 */

public class IdenticalTree {
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
    boolean isIdentical(Node root1,Node root2){
        if(root1==null || root2==null){
            return(root1==root2);
        }
        return (root1.data==root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
    }
}
