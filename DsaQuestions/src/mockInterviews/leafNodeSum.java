package mockInterviews;

public class leafNodeSum {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    static int sum=0;
    static void lesfNodeSum(Node root){
        if(root==null){
            return;
        }
        if(isLeafNode(root)){
            sum+=root.val;
        }
        lesfNodeSum(root.left);
        lesfNodeSum(root.right);
    }
    static boolean isLeafNode(Node node){
        if(node.left==null && node.right==null){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*

             8                                                8
                                                            /   \
            / \                                             10   5
                                                            / \  /  \
                                                          11  9  7  3
            5  10
          /  \  / \
          3  7  9  11     ans= 3+7+9+11=30
         */
        Node root= new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right= new Node(10);
        root.right.left=new Node(9);
        root.right.right= new Node(11);
        Node node= new Node(8);
        node.left= new Node(10);
        node.left.left= new Node(11);
        node.left.right= new Node(9);
        node.right= new Node(5);
        node.right.right= new Node(3);
        node.right.left= new Node(10);

        System.out.println(isMirrorImage(root,node));
//        lesfNodeSum(root);
//        System.out.println(sum);
    }
    // mirror images
    static boolean isMirrorImage(Node root1, Node root2){
        if(root1==null){
            return root1==root2;
        }
        //
        if(root1.val== root2.val){
            return isMirrorImage(root1.left,root2.right) && isMirrorImage(root1.right,root2.left);
        }
        return false;
    }

}
