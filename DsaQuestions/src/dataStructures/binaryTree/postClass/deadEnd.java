package dataStructures.binaryTree.postClass;
/*
Given a Binary search Tree that contains positive integer values greater then 0. The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false. Here Dead End means, we are not able to insert any element after that node.

Examples:

Input :
               8
             /   \
           5      9
         /  \
        2    7
       /
      1

Output : Yes
Explanation : Node "1" is the dead End because after that
              we cant insert any element.
 */
public class deadEnd {
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return containsDeadEnd(root,0,Integer.MAX_VALUE);
    }
    public static boolean containsDeadEnd(Node root, int min, int max){
        if(root==null){
            return false;
        }
        if(root.data==min+1 && root.data==max-1){
            return true;
        }
        return containsDeadEnd(root.left, min, root.data)|| containsDeadEnd(root.right,root.data,max);
    }
}
