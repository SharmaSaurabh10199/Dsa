package dataStructures.binaryTree.bst;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallesAndLargest {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val = data;
            left=null;
            right=null;
        }
    }
    // this solution is not space complexity wise optimized.
    // 0(n),0(n) time and space complexity.
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ls= new ArrayList<>();
        inOrder(root,ls);
        int kthSmallest= ls.get(k-1);
        int kthLargest= ls.get(ls.size()-1);
        return kthSmallest;

    }
    void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    // optimzed solution
    // time complexity= o(h+k) space complexity =o(h)
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> st= new Stack<>();

        int res=-1;
        while (true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }
            else {
                if(st.isEmpty()){
                    break;
                }
                root= st.pop();
                k--;
                if(k==0) {
                    res=root.val;
                    break;
                }
                root=root.right;
            }
        }
        return res;

    }

}
