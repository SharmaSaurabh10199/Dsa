package dataStructures.binaryTree.bst;
/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
 */
public class LargestbstInBinaryTree {
   static  class pair{
        int minNode;
        int maxNode;
        int size;
        public pair(int minNode, int maxNode, int size){
            this.maxNode=maxNode;
            this.minNode=minNode;
            this.size=size;
        }
    }
    static pair helper(Node root){
        if(root==null){
            return new pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        pair left= helper(root.left);
        pair right= helper(root.right);
        if(root.val>left.maxNode && root.val<right.minNode){
            return new pair(Math.min(root.val,left.minNode), Math.max(root.val, right.maxNode),
                    1+ left.size+right.size);
        }
        return new pair(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size, right.size));
    }
    static int largestBst(Node root)
    {
        return helper(root).size;
    }


}
