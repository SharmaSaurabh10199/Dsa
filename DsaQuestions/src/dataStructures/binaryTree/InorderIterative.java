package dataStructures.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    // Iterative Inorder
    public List<Integer> IterativeInorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (true) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                curr = st.pop();
                list.add(curr.val);
                curr = curr.right;

            }
        }
        return list;
    }

    // Iterative postOrder
    public List<Integer> IterativePostOrder(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node node = st1.pop();
            st2.push(node);
            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }
        while (!st2.isEmpty()) {
            list.add(st2.pop().val);
        }
        return list;
    }
}
