
package dataStructures.binaryTree.postClass;

import java.util.*;

/*
Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.



Example 1:

Input:
        3
      /   \
     2     1
Output:
3 1 2

Example 2:

Input:
           7
        /     \
       9       7
     /  \     /
    8    8   6
   /  \
  10   9
Output:
7 7 9 8 8 6 9 10
 */
// approach: the approach is to create 2 stacks, while traversng hrough one, keep pushing the childs in reverse
// order in other stack, and repeat the same on other stack untill both the stacks are empty.
public class ZigZagTraversal {
    static public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                ls.add(temp.data);
                if (temp.left != null) {
                    s2.push(temp.left);
                }
                if (temp.right != null) {
                    s2.push(temp.right);
                }
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                ls.add(temp.data);
                if (temp.right != null) {
                    s1.push(temp.right);
                }
                if (temp.left != null) {
                    s1.push(temp.left);
                }
            }
        }
        return ls;
    }

    // further optimized solution:o(n) time complexity, o(n) space complexity
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        Deque<Node> dq = new ArrayDeque<>();
        List<List<Integer>> ls = new ArrayList<>();
        // Vector<Integer> v= new Vector<>();
        if (root == null) {
            return ls;
        }
        boolean flag = true;
        dq.push(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> subList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node temp = dq.poll();
                if (flag) {
                    subList.add(temp.data);
                } else {
                    subList.add(0, temp.data);
                }
                if (temp.left != null) {
                    dq.add(temp.left);
                }
                if (temp.right != null) {
                    dq.add(temp.right);
                }
            }
            flag = !flag;
            // here you can print the list.

            ls.add(subList);
        }
        return ls;
    }

}
