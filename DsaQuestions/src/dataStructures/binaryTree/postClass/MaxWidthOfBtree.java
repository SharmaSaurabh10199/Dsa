package dataStructures.binaryTree.postClass;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBtree {
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
    class pair{
        int num;
        TreeNode node;
        public pair(int num, TreeNode node){
            this.num=num;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q= new LinkedList<>();
        q.add(new pair(0,root));
        int ans=0;
        if(root==null){
            return ans;
        }
        while (!q.isEmpty()){
            //pair p= q.peek();
            int min= q.peek().num;
            int first=0,last=0;
            int size=q.size();
            for (int i = 0; i < size; i++) {
                pair p= q.poll();
                int currNewNum= p.num-min;
                if(i==0) first=currNewNum;
                if(i==size-1) last=currNewNum;
                if(p.node.left!=null){
                    q.add( new pair(2*currNewNum+1,p.node.left));
                }
                if(p.node.right!=null){
                    q.add(new pair(2*currNewNum+2,p.node.right));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
