package dataStructures.binaryTree.postClass;

public class Kthancestor {
    // approach 1:
    /*
      steps: 1) store the node to root path in some array
             2) now the kth ancestor is the element is the kth element of arraylist from the end.
       // approach 2:
      steps: 1) solve it recursively, idea is to look for the node given, while coming back from the
       recursive call decrese k and check if k is 0, return that perticular node.
     */
    int K;
    Node kthAncestor(Node root, int node){
        if(root==null || root.data==node){
            return root;
        }
        Node left= kthAncestor(root.left,node);
        Node right= kthAncestor(root.right,node);
        if(left!=null && right==null){
            K--;
            if(K==0){
                return root;
            }
            return left;
        }
        else if(right!=null && left==null){
            K--;
            if(K==0){
                return root;
            }
            return right;
        }
        else {
            return null;
        }
    }
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        K=k;

        Node res= kthAncestor(root,node);
        if(root==null || K>0){
            return -1;
        }
        return res.data;
    }
}
