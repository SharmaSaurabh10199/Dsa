package dataStructures.binaryTree.postClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    public ArrayList<Integer> diagonal(Node root)
    {
        //add your code here.
        ArrayList<Integer> ls= new ArrayList<>();
        Queue<Node > q= new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node temp= q.poll();
            while (temp!=null){
                if(temp.left!=null){
                    q.add(temp.left);
                }
                ls.add(temp.data);
                temp=temp.right;
            }
        }
        return ls;
    }
}
