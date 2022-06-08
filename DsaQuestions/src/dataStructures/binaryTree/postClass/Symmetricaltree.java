package dataStructures.binaryTree.postClass;
/*

Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.

Example 1:

Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: True
Explanation: Tree is mirror image of
itself i.e. tree is symmetric

Example 2:


Input:
         5
       /   \
      10     10
     /  \     \
    20  20     30
Output: False
 */
public class Symmetricaltree {

    static public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public boolean isMirror(Node root1,Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1!=null && root2!=null && root1.data==root2.data){
            return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Symmetricaltree tree= new Symmetricaltree();
        Node newNode= new Node(1);
        //Symmetricaltree.Node
        newNode.left=new Node(2);
        newNode.left.left=new Node(3);
        newNode.right=new Node(3);
        newNode.right.right=new Node(3);
        System.out.println(tree.isMirror(newNode.left,newNode.right));;


    }
}
