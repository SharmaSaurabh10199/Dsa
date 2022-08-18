package dataStructures.binaryTree.postClass;

import java.util.*;

/*
Given a binary tree denoted by root node A and a leaf node B from this tree.

 It is known that all nodes connected to a given node (left child, right child and parent) get burned in 1 second. Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on.

You need to find the minimum time required to burn the complete binary tree.


 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class TimeToBurnTree {
    static HashMap<TreeNode, TreeNode> parents;
    static HashMap<TreeNode, Boolean> visited;

    static public void markParents(TreeNode root) {
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            if (node.left != null) {
                parents.put(node.left, node);
                temp.add(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                temp.add(node.right);
            }

        }
    }

    public static int timeToBurnTree(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        visited = new HashMap<>();
        markParents(root);
        visited.put(target, true);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                if (parents.get(node) != null && visited.get(parents.get(node)) == null) {
                    q.add(parents.get(node));
                    visited.put(parents.get(node), true);
                }
            }
            time++;
        }
        return time;

    }

}
