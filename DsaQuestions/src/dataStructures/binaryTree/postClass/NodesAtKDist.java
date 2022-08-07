package dataStructures.binaryTree.postClass;

import java.util.*;

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of
all nodes that have a distance k from the target node.
 */
public class NodesAtKDist {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static HashMap<TreeNode, TreeNode> parents;
    static HashMap<TreeNode, Boolean> visited;

    static public void markParents(TreeNode root) {
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            if(node.left!=null){
                parents.put(node.left,node);
                temp.add(node.left);
            }
            if(node.right!=null){
                parents.put(node.right,node);
                temp.add(node.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents= new HashMap<>();
        visited= new HashMap<>();
        markParents(root);
        visited.put(target,true);
        Queue<TreeNode> q= new LinkedList<>();
        q.add(target);
        int dis=0;
        while(!q.isEmpty()){
            if(dis==k){
                break;
            }
            int size= q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node= q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.add(node.right);
                    visited.put(node.right,true);
                }
                if(parents.get(node)!=null && visited.get(parents.get(node))==null){
                    q.add(parents.get(node));
                    visited.put(parents.get(node),true);
                }
            }
            dis++;
        }
        List<Integer> res= new ArrayList<>();
        while (!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;

    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left= new TreeNode(5);
        root.right= new TreeNode(1);
        root.left.left= new TreeNode(6);
        root.left.right=new TreeNode(2);
        List<Integer> ls= distanceK(root,root.left,1);
        System.out.println(ls);

    }
}
