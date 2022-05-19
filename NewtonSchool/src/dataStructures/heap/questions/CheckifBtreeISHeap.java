package dataStructures.heap.questions;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class CheckifBtreeISHeap {
    boolean isHeap(Node root) {
        int nodeCount= countNodes(root);
        if(!isComplete(root,1,nodeCount)){
            return false;
        }
        // code here
        if(!checkHeap(root)){
            return false;
        }
        return true;
    }
    boolean checkHeap(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null || root.right==null){
            if(root.left==null && root.right==null){
                return true;
            }
            return root.data>=root.left.data;
        }
        else {
            if(root.data>= root.left.data && root.data>=root.right.data ){
                return checkHeap(root.left) && checkHeap(root.right);
            }
            return false;
        }

    }
    boolean isComplete(Node root, int index, int nodeCount){
        if(root==null){
            return true;
        }
        if(index>nodeCount){
            return false;
        }
        return isComplete(root.left,2*index,nodeCount)
                && isComplete(root.right,2*index+1,nodeCount);

    }
    int countNodes(Node root){
        if(root==null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
