package dataStructures.binaryTree.postClass;

import java.util.*;

public class TopAndBottomView {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {

            this.data = data;
            left = null;
            right = null;
        }
    }

    static class pair {
        int hd;
        Node node;

        public pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static ArrayList<Integer> getTopView(Node root) {
        // Write your code here.
        Queue<pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(new pair(0, root));
        while (!q.isEmpty()) {
            pair p = q.poll();
            int hd = p.hd;
            Node n = p.node;
            // avoid overriding for the top value
            if (!map.containsKey(hd)) {
                map.put(hd, n.data);
            }
            if (n.left != null) {
                q.add(new pair(hd - 1, n.left));
            }
            if (n.right != null) {
                q.add(new pair(hd + 1, n.right));
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            list.add(item.getValue());
        }
        return list;
    }

    // bottom view of btree
    public static ArrayList<Integer> getBottomView(Node root) {
        // Write your code here.
        Queue<pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(new pair(0, root));
        while (!q.isEmpty()) {
            pair p = q.poll();
            int hd = p.hd;
            Node n = p.node;
            // override for the bottom value
            map.put(hd, n.data);
            if (n.left != null) {
                q.add(new pair(hd - 1, n.left));
            }
            if (n.right != null) {
                q.add(new pair(hd + 1, n.right));
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            list.add(item.getValue());
        }
        return list;
    }
}
