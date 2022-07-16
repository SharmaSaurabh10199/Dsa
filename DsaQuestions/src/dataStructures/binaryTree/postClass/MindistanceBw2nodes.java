package dataStructures.binaryTree.postClass;
// approach:
  /*
     steps: 1) find the lca of both nodes
            2) find distance of one node from lca(d1) and distance of another from one node(d2)
            3) return d1+d2;
   */
public class MindistanceBw2nodes {
    public Node lowestCommonAncestor(Node root, int  p, int q) {
        if(root==null || root.data==p || root.data ==q){
            return root;
        }
        Node left= lowestCommonAncestor(root.left,p,q);
        Node right= lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else {
            return root;
        }

    }
    public int findDistance(Node root, int k,int dist){
        if(root==null){
            return -1;
        }
        if(root.data==k){
            return dist;
        }
        int left= findDistance(root.left,k,dist+1);
        if(left!=-1){
            return left;
        }
        return findDistance(root.right,k,dist+1);
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca= lowestCommonAncestor(root,a,b);
        int d1= findDistance(lca,a,0);
        int d2= findDistance(lca,b,0);
        return d1+d2;
    }
    
}
