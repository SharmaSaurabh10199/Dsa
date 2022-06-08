package dataStructures.binaryTree.postClass;
/*
Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input:
            1
          /   \
         2     3

Output: 1

Explanation:
Leaves 2 and 3 are at same level.

Example 2:

Input:
            10
          /    \
        20      30
       /  \
     10    15

Output: 0

Explanation:
Leaves 10, 15 and 30 are not at same level.
 */
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LeafAtSameLevel {
    int leafLevel=0;
    boolean check(Node root)
    {
        return checkLeafLevel(root,0);
    }
    boolean checkLeafLevel(Node root, int level){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            if(leafLevel==0){
                leafLevel=level;
                return true;
            }
            return level==leafLevel;
        }
        return checkLeafLevel(root.left,level+1) && checkLeafLevel(root.right,level+1);
    }



}
