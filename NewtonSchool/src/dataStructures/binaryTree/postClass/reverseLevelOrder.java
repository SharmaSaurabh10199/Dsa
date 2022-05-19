package dataStructures.binaryTree.postClass;

import java.util.*;

/*
Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.
Input :
       10
      /  \
     20   30
    / \
   40  60

Output: 40 60 20 30 10
Explanation:
Traversing level 2 : 40 60
Traversing level 1 : 20 30
Traversing level 0 : 10
 */
public class reverseLevelOrder {
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public ArrayList<Integer> reverseLevelOrder(Node node)
    {
        ArrayList<Integer> res= new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        Queue<Node> q= new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            Node n= q.poll();
            if(n.right!=null){
                q.add(n.right);
            }
            if(n.left!=null){
                q.add(n.left);
            }
            st.push(n.data);
        }
        while (!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }

}
