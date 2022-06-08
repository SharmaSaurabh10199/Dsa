package dataStructures.binaryTree.bst;


import java.util.ArrayList;
import java.util.List;

public class NormalToBalancedBSt {
    class Node
    {
        int data;
        Node right, left;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    Node buildBalancedTree(Node root)
    {
        //Add your code here.
        ArrayList<Integer> ls= new ArrayList<>();
        fillInOrder(root,ls);
        return makeBalancedTree(ls,0,ls.size()-1);
    }
    Node makeBalancedTree(ArrayList<Integer> ls, int start, int end){
        if(start>end){
            return null;
        }
        int mid= start+(end-start)/2;
        Node node= new Node(ls.get(mid));
        node.left= makeBalancedTree(ls,start,mid-1);
        node.right= makeBalancedTree(ls,mid+1,end);
        return node;
    }
    public void fillInOrder(Node root, List<Integer> ls){
        if(root==null){
            return;
        }
        fillInOrder(root.left,ls);
        ls.add(root.data);
        fillInOrder(root.right,ls);
    }

}
