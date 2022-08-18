package dataStructures.binaryTree.postClass;

import java.util.PriorityQueue;

public class BianaryTreeTobst {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    Node binaryTreeToBST(Node root) {
        // Your code here
        insert(root);
        reconstruct(root);
        return root;
    }

    void insert(Node root) {
        if (root == null) {
            return;
        }
        pq.add(root.data);
        insert(root.left);
        insert(root.right);
    }

    void reconstruct(Node root) {
        if (root == null) {
            return;
        }
        reconstruct(root.left);
        root.data = pq.poll();
        reconstruct(root.right);
    }
}
